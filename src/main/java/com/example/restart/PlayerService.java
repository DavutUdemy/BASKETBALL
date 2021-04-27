package com.example.restart;

import com.example.restart.BadRequest.BadRequestException;
import com.example.restart.Player.Player;
import com.example.restart.Player.PlayerRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    private final PlayerRepository playerRepository;

    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean ExistsEmail(String name){
        return playerRepository.selectExistsEmail(name);
    }

    @Override
    public Player createPlayer(Player player) {
        if(!ExistsEmail(player.getName())){
            throw new BadRequestException("There is a user with the same name");

        }
        Object result = BussinesModel.run(MaxPlayer());
        if (result == null){
            throw new BadRequestException("Please follow the rules");

        }
        return      playerRepository.save(player);
    }


    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> getById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {

        playerRepository.deleteById(id);
        return "Player succesfully deleted";
    }

    private boolean MaxPlayer(){
        if (playerRepository.findAll().size() < 15){
            return true;
        }
        return false;
    }
}
