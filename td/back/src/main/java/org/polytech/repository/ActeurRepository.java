package org.polytech.repository;

import java.util.List;

import org.polytech.acteur.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long>{

    List<Acteur> findByNom(String nom);

}
