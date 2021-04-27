package com.example.restart;
  import com.example.restart.Player.Player;
  import com.example.restart.Player.PlayerRepository;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
  import javax.validation.Valid;


import java.util.List;

@Controller

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/players")

public class PlayerController {
    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }


    @PostMapping
    public void registerNewShoe(@Valid @RequestBody Player player){
        playerService.createPlayer(player);

    }

    @GetMapping
    public List<Player> getShoes(){
        return playerService.getAll();
    }    @DeleteMapping
    public void DeleteAll(){
        playerRepository.deleteAll();
    }
    @DeleteMapping(path = "{id}")
    public void deleteShoes(@PathVariable("id")Long id){
        playerService.deleteById(id);
    }
}
