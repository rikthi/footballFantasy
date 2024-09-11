package com.ff.footballfantasy.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "app/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String team){
        if (name != null && team != null){
            return playerService.getPlayersByName(name).stream().filter(player -> team.equals(player.getTeam())).collect(Collectors.toList());
        }
        else if (name != null){
            return playerService.getPlayersByName(name);
        }
        else if(team != null){
            return playerService.getPlayerByTeam(team);
        }
        else{
            return playerService.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player addedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(addedPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(Player player){
        Player playerToUpdate = playerService.updatePlayer(player);

        if (playerToUpdate != null){
            return new ResponseEntity<>(playerToUpdate, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
