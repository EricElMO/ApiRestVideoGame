package com.example.apirestvideogames.controller;


import com.example.apirestvideogames.model.entities.VideoGame;
import com.example.apirestvideogames.model.services.ServiceVideoGames;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerVideoGames {

    private final ServiceVideoGames serviceRepository;

    @GetMapping("/video-games/{id}")
    public ResponseEntity<?> getVideoGame(@PathVariable int id)
    {
        VideoGame videojoc = serviceRepository.getVideoGame(id);

        if(videojoc == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videojoc);

    }

    @GetMapping("/video-games")
    public ResponseEntity<?> getListVideoGame(@RequestParam (value="genere", required=false) String genere)
    {
        List<VideoGame> videojocs;

        if(genere==null)
            videojocs = serviceRepository.listVideoGames();
        else
            videojocs = serviceRepository.listVideoGamesGenere(genere);

        if(videojocs == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videojocs);

    }

    @GetMapping("/video-games/count/{genre}")
    public ResponseEntity<?>  countByGenre(@PathVariable String genre){
        long count = serviceRepository.countByGenere(genre);
        return ResponseEntity.ok(count);
    }


    @PostMapping("/video-games")
    public ResponseEntity<?>  addVideoGame(@RequestBody VideoGame newVideoGame){
        VideoGame videoGame = serviceRepository.addVideoGame(newVideoGame);
        return new ResponseEntity<VideoGame>(videoGame, HttpStatus.CREATED);

    }

    @GetMapping("/video-games/{price}")
    public ResponseEntity<?> listVideoGames(@RequestParam(value="price", required=false) Double price){
        if(price==null){
            return ResponseEntity.ok(serviceRepository.listVideoGames());
        }
        else return ResponseEntity.ok(serviceRepository.findByPrice(price));
    }


    @DeleteMapping("/video-games/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        VideoGame videojoc = serviceRepository.deleteVideoGame(id);
        if(videojoc == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videojoc);
    }

    @PutMapping("/video-games")
    public ResponseEntity<?>  updateVideoGame(@RequestBody VideoGame upatedVideoGame){

        return ResponseEntity.ok(serviceRepository.setVideoGame(upatedVideoGame));

    }
}
