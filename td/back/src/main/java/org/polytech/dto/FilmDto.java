package org.polytech.dto;

import java.time.LocalDate;

import org.polytech.films.Genrefilms;

public record FilmDto(
    Long id,
    String titre,
    String realisateur,
    LocalDate dateSortie,
    Genrefilms genre){
}

