package org.polytech.repository;

import java.util.List;

import org.polytech.acteur.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long>{
    List<Acteur> findByFilmsId(Long filmId);
    @Query("SELECT acteurs FROM Acteur acteurs JOIN acteurs.films film WHERE film.id = :filmId")
    List<Acteur> findActeursByFilmId(@Param("filmId") Long filmId);
}
