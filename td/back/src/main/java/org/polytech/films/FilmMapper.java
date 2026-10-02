package org.polytech.films;

public final class FilmMapper {
    private FilmMapper() {
    }

    public static FilmDto toDto(Film film) {
        return new FilmDto(
                film.getId(),
                film.getTitre(),
                film.getRealisateur(),
                film.getDateSortie(),
                film.getGenre());
    }

    /**
     * Cette méthode accède à la relation medecinTraitant. Elle n'est donc
     * appelable que sur un patient chargé avec un JOIN FETCH, ou à l'intérieur
     * d'une transaction ; à défaut, LazyInitializationException.
     */
    public static PatientDetailDto toDetailDto(Patient patient) {
        String medecin = patient.getMedecinTraitant() == null
                ? null
                : "%s %s".formatted(patient.getMedecinTraitant().getPrenom(),
                                    patient.getMedecinTraitant().getNom());
        return new PatientDetailDto(
                patient.getId(),
                patient.getPrenom(),
                patient.getNom(),
                patient.getEmail(),
                patient.getDateNaissance(),
                medecin);
    }

    public static Patient toEntity(PatientCreationDto dto) {
        Patient patient = new Patient();
        patient.setPrenom(dto.prenom());
        patient.setNom(dto.nom());
        patient.setEmail(dto.email());
        patient.setDateNaissance(dto.dateNaissance());
        return patient;
    }
}
