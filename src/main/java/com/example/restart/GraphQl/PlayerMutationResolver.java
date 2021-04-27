package com.example.restart.GraphQl;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.restart.Dto.PlayerDto;
import com.example.restart.IPlayerService;
import com.example.restart.Player.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {
    private  final IPlayerService iplayerService;



    public Player createPlayer(PlayerDto playerDto) {
        return iplayerService.createPlayer(dtoToEntity(playerDto));
    }

    private Player dtoToEntity(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setLastName(playerDto.getLastName());
        player.setPosition(playerDto.getPosition());
        return player;
    }
    public String deletePlayer(Long id) {
                iplayerService.deleteById(id);
        return "Player succesfully deleted";
    }


}