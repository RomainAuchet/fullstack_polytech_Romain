package org.polytech.films;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository 
public class FilmsRepo implements FilmStore{
    private final List<Film> films= new ArrayList<>();

     @PostConstruct 
    public void init(){
        Create("La vie","John", LocalDate.of(2026,9,24), Genrefilms.ACTION);
    }
    @Override 
    public void saveFilm(Film film){
        films.add(film);
    }
    @Override 
    public Film getFilmbyID(int id){
        return films.get(id-1);
    }
    @Override 
    public List<Film> getallFilms(){
        return films;
    }
    @Override 
    public void Create(String titre, String realisateur, LocalDate DateSortie, Genrefilms genre){
        int id= (films.size())+1;
        Film newfilm = new Film(id,titre, realisateur, DateSortie, genre);
        saveFilm(newfilm);
}
}
