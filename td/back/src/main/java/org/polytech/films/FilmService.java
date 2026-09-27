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
    public Film createFilm(String titre, String realisateur, LocalDate dateSortie, Genrefilms genre){
        if (titre == null) {
            throw new IllegalArgumentException("titre obligatoire");
        }
        Film film = store.Create(titre, realisateur, dateSortie, genre);
        return film;
    }
    public Film getFilmbyID(int id){
        return store.getFilmbyID(id);
    }
    public List<Film> getALLFilm(){
        return store.getallFilms();
    }
    
}
