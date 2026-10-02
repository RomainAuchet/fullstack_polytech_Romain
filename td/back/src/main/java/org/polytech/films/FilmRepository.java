package org.polytech.films;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<Film, Long>{
    List<Film> findByTitre(String titre);
    List<Film> findByTitreAndDateSortieAfter(
    String titre, LocalDate date);
    List<Film> findByEmailContainingIgnoreCase(
    String extrait);
    Optional<Film> findFirstByOrderByDateNaissanceDesc();

}

