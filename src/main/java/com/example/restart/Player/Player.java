package com.example.restart.Player;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"

    )
    private Long Id;
    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotEmpty(message = "LastName can not be empty")
    private String lastName;
    @NotEmpty(message = "Position can not be empty")
    private String position;

    public Player() {
    }


    public Player(Long id, String name, String lastName, String position) {
        Id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public Player(String name, String lastName, String position) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
