package org.polytech.films;

import java.time.LocalDate;
import java.util.List;

public interface FilmStore {
    public void saveFilm(Film film);
    public Film getFilmbyID(int id);
    public List<Film> getallFilms();
    public Film Create(String titre, String realisateur, LocalDate dateSortie, Genrefilms genre);
    public Film Update(int id, FilmRequest film);
    public void Delete(int id);
}
