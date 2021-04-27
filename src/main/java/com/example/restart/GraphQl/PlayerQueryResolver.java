package com.example.restart.GraphQl;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.restart.IPlayerService;
import com.example.restart.Player.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {
    private final IPlayerService playerService;



    public List<Player> getPlayers(String type) {
        return playerService.getAll();
    }

    public Optional<Player> getById(Long id) {
        return playerService.getById(id);
    }

}
