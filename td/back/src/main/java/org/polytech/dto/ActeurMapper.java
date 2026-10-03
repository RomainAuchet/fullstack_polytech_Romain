package org.polytech.dto;

import java.util.List;

import org.polytech.acteur.Acteur;

public class ActeurMapper {
    private ActeurMapper() {
    }

    public static ActeurDto toDto(Acteur acteur) {
        return new ActeurDto(
                acteur.getId(),
                acteur.getNom(),
                acteur.getPrenom());
    }


    public static Acteur toEntity(ActeurCreationDto dto) {
        Acteur acteur = new Acteur();
        acteur.setNom(dto.nom());
        acteur.setPrenom(dto.prenom());
        return acteur;
    }
    public static ActeurDetailDto toDetailDto(Acteur acteur) {
      List<FilmDto> films = acteur.getFilms().stream()
            .map(FilmMapper::toDto)
            .toList();
        return new ActeurDetailDto(
                acteur.getId(),
                acteur.getNom(),
                acteur.getPrenom(),
                films);
    }
}
