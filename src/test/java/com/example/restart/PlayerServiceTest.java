package com.example.restart;

import com.example.restart.BadRequest.BadRequestException;
import com.example.restart.Player.Player;
import com.example.restart.Player.PlayerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoInitializationException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @Mock private PlayerRepository playerRepository;
    private PlayerService playerService;

    @Mock
    private AutoCloseable autoCloseable;
    @BeforeEach
    void SetUP() {
        AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);
        playerService= new PlayerService(playerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStudent(){

        playerService.getAll();
        verify(playerRepository).findAll();

    }
    @Test
    void addNewPlayer() {
        Player player = new Player(
                "Davud",
                "Mamedov",
                "C"
        );


        playerService.createPlayer(player);
        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(playerRepository).save(playerArgumentCaptor.capture());
        Player player1 =  playerArgumentCaptor.getValue();
        assertThat(player1).isEqualTo(player);

    }


    public boolean ExistsEmail(String name){
        return playerRepository.selectExistsEmail(name);
    }

    private boolean MaxPlayer(){
        if (playerRepository.findAll().size() < 15){
            return true;
        }
        return false;
    }





    @Test
    void DeleteById()
    {
        Long id = 4L;
        boolean validId = playerRepository.findPlayerById(id).isPresent();
        if(!validId){
            throw new BadRequestException(
                    "Player with id  " + id + "does not exists"
            );
        }
        playerService.deleteById(id);
        verify(playerRepository).deleteById(id);


    }


}
