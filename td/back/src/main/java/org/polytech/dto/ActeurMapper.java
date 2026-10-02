package org.polytech.dto;

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
}
