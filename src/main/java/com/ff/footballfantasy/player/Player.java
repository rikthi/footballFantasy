package com.ff.footballfantasy.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {
    @Id
    @Column(name = "name", unique = true)
    private String player_name;
    private String team;
    private Integer games_played;
    private Integer games_subbed;
    private Integer minutes_played;
    private Integer goals;
    private Integer assists;
    private Integer shots;
    private Integer shots_on_target;

    public Player() {
    }

    public Player(String player_name, String team, Integer games_played, Integer games_subbed, Integer minutes_played, Integer goals, Integer assists, Integer shots, Integer shots_on_target) {
        this.player_name = player_name;
        this.team = team;
        this.games_played = games_played;
        this.games_subbed = games_subbed;
        this.minutes_played = minutes_played;
        this.goals = goals;
        this.assists = assists;
        this.shots = shots;
        this.shots_on_target = shots_on_target;
    }

    public Player(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getTeam() {
        return team;
    }

    public Integer getGames_played() {
        return games_played;
    }

    public Integer getGames_subbed() {
        return games_subbed;
    }

    public Integer getMinutes_played() {
        return minutes_played;
    }

    public Integer getGoals() {
        return goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public Integer getShots() {
        return shots;
    }

    public Integer getShots_on_target() {
        return shots_on_target;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setGames_played(Integer games_played) {
        this.games_played = games_played;
    }

    public void setGames_subbed(Integer games_subbed) {
        this.games_subbed = games_subbed;
    }

    public void setMinutes_played(Integer minutes_played) {
        this.minutes_played = minutes_played;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public void setShots_on_target(Integer shots_on_target) {
        this.shots_on_target = shots_on_target;
    }
}
