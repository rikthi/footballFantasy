package com.ff.footballfantasy.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayerByTeam(String teamName){
        return playerRepository.findAll().stream().filter(player -> teamName.equals(player.getTeam())).collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player editedPlayer){
        Optional<Player> currentPlayer = playerRepository.findByName(editedPlayer.getName());
        if (currentPlayer.isPresent()){
            Player playerToUpdate = currentPlayer.get();
            playerToUpdate.setTeam(editedPlayer.getTeam());
            playerToUpdate.setGames_played(editedPlayer.getGames_played());
            playerToUpdate.setGames_subbed(editedPlayer.getGames_subbed());
            playerToUpdate.setMinutes_played(editedPlayer.getMinutes_played());
            playerToUpdate.setGoals(editedPlayer.getGoals());
            playerToUpdate.setAssists(editedPlayer.getAssists());
            playerToUpdate.setShots(editedPlayer.getShots());
            playerToUpdate.setShots_on_target(editedPlayer.getShots_on_target());

            playerRepository.save(playerToUpdate);
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }
}
