package org.polytech.films;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class FilmService {
    private final FilmStore store;

    public FilmService(FilmStore store)
     {
        this.store = store;
    }
    public void createFilm(String titre, String realisateur, LocalDate DateSortie, Genrefilms genre){
        store.Create(titre, realisateur, DateSortie, genre);
    }
    public Film getFilmbyID(int id){
        return store.getFilmbyID(id);
    }
    public List<Film> getALLFilm(){
        return store.getallFilms();
    }
    
}
