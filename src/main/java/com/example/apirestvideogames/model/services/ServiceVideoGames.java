package com.example.apirestvideogames.model.services;


import com.example.apirestvideogames.model.entities.VideoGame;
import com.example.apirestvideogames.model.repositories.RepositoryVideoGames;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceVideoGames {
    private final RepositoryVideoGames repositoryVideoGames;

    public List<VideoGame> listVideoGames(){return repositoryVideoGames.findAll(); }

    public List<VideoGame> findByPrice(double price){ return repositoryVideoGames.findByPrice(price); }

    public List<VideoGame> listVideoGamesGenere(String genre){
        return repositoryVideoGames.findByGenere(genre);
    }

    public Long countByGenere(String genre){
        return repositoryVideoGames.countByGenere(genre);
    }

    public VideoGame getVideoGame(int id){
        return repositoryVideoGames.findById(id).orElse(null);
    }

    public VideoGame addVideoGame(VideoGame it){
        return repositoryVideoGames.save(it);
    }

    public VideoGame setVideoGame(VideoGame videoGame){
        VideoGame aux=null;
        if(repositoryVideoGames.existsById(videoGame.getIdVideoGame())) aux= repositoryVideoGames.save(videoGame);
        return aux;
    }

    public VideoGame deleteVideoGame(int id){
        VideoGame res= repositoryVideoGames.findById(id).orElse(null);
        if(res!=null) repositoryVideoGames.deleteById(id);
        return res;
    }
}
