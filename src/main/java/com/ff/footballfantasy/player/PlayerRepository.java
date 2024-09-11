package com.ff.footballfantasy.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {
    void deletePlayer(String name);
    Optional<Player> findPlayer(String name);


}
