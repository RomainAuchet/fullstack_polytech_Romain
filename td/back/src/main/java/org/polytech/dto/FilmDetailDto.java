package org.polytech.dto;

import java.time.LocalDate;
import java.util.List;

import org.polytech.films.Genrefilms;

public record FilmDetailDto(Long id,
    String titre,
    String realisateur,
    LocalDate dateSortie,
    Genrefilms genre,
    List<ActeurDto> acteurs) {

}
