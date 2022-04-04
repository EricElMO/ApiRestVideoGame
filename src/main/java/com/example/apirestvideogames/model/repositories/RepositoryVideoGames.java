package com.example.apirestvideogames.model.repositories;

import com.example.apirestvideogames.model.entities.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryVideoGames extends JpaRepository<VideoGame, Integer> {
    List<VideoGame> findByGenere(String genere);
    long countByGenere(String genere);
    List<VideoGame> findByPrice(double price);
}
