package org.polytech.films;

import java.time.LocalDate;
import java.util.List;

public interface FilmStore {
    public void saveFilm(Film film);
    public Film getFilmbyID(int id);
    public List<Film> getallFilms();
    public void Create(String titre, String realisateur, LocalDate DateSortie, Genrefilms genre);
}
