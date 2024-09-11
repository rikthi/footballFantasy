package com.ff.footballfantasy.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
