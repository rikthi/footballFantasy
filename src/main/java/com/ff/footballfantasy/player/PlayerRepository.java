package com.ff.footballfantasy.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {
    void deleteByName(String player_name);
    Optional<Player> findByName(String player_name);


}
