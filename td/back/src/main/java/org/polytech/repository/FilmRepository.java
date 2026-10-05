package org.polytech.repository;


import java.util.List;

import org.polytech.films.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
    List<Film> findByActeursId(Long acteurId);
    @Query("SELECT film FROM Film film JOIN film.acteurs acteurs WHERE acteurs.id = :acteurId")
    List<Film> findFilmsByActeurId(@Param("acteurId") Long acteurId);
}

