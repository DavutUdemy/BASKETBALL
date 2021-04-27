package com.example.restart;

import com.example.restart.Player.Player;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IPlayerService {

    Player createPlayer(Player player);
    List<Player> getAll();
    Optional<Player> getById(Long id);

    String deleteById(Long id);
}