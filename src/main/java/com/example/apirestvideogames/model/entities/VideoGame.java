package com.example.apirestvideogames.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class VideoGame {
    @Id
    private int idVideoGame;
    private String name;
    private String genere;
    private double price;
}
