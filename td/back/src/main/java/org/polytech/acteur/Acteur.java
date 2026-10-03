package org.polytech.acteur;

import java.util.HashSet;
import java.util.Set;

import org.polytech.films.Film;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Acteur {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length=60)
    private  String nom;
    private  String prenom;
    @ManyToMany(mappedBy = "acteurs")
    private Set<Film> films = new HashSet<>();          

    public Acteur(){}

    public Acteur(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
}
    public Long getId(){ 
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setFilms(Set<Film> films) {
        this.films = films;
    }
    public Set<Film> getFilms(){
        return this.films;
    }
}

