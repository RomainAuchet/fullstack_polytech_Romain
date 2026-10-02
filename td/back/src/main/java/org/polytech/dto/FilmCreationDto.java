package org.polytech.dto;

import java.time.LocalDate;

import org.polytech.films.Genrefilms;

public record FilmCreationDto(

    String titre,
    String realisateur,
    LocalDate dateSortie,
    Genrefilms genre){
}

