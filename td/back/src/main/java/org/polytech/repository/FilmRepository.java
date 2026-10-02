package org.polytech.repository;


import java.time.LocalDate;
import java.util.List;

import org.polytech.films.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
    List<Film> findByTitre(String titre);
    List<Film> findById(long id);
    List<Film> findByTitreAndDateSortieAfter(
    String titre, LocalDate date);

}

