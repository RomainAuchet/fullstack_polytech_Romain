package org.polytech.films;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

@Deprecated
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
    public Film Create(String titre, String realisateur, LocalDate dateSortie, Genrefilms genre){
        Long id= (long) (films.size())+1;
        Film newfilm = new Film(id,titre, realisateur, dateSortie, genre);
        saveFilm(newfilm);
        return newfilm;
    }
    @Override 
    public Film Update(int id, FilmRequest film){   
        Film newfilm= new Film((long)id,film.getTitre(),film.getRealisateur(),film.getDateSortie(),film.getGenre());
        films.set(id-1,newfilm);
        return newfilm;
    }
    @Override 
    public void Delete(int id){
        films.set(id-1,null); //pour ne pas casser la logique d'id on change simplement en null
    }
}
