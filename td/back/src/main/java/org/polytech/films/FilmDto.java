package org.polytech.films;

import java.time.LocalDate;

public record FilmDto(
    int id,
    String titre,
    String realisateur,
    LocalDate dateSortie,
    Genrefilms genre){
}

