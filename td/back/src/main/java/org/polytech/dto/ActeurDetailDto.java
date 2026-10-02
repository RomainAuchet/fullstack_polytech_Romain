package org.polytech.dto;

import java.util.List;

public record ActeurDetailDto(
    Long id, 
    String nom,
    String prenom,
    List<FilmDto> films){

    }
