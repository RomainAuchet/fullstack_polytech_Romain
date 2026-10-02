package org.polytech.films;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.polytech.acteur.Acteur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity 
public class Film {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length=200)
    private  String titre;
    private  String realisateur;
    private  LocalDate dateSortie;
    private Genrefilms genre;
    @ManyToMany
    @JoinTable(
        name = "acteur_film",
        joinColumns = @JoinColumn(name = "id_film"),
        inverseJoinColumns = @JoinColumn(name = "id_acteur")
    )
    private Set<Acteur> acteurs = new HashSet<>();

    public Film() {
    }

    public Film(Long id, String titre, String realisateur, LocalDate dateSortie, Genrefilms genre){
        this.id=id;
        this.titre=titre;
        this.realisateur=realisateur;
        this.dateSortie=dateSortie;
        this.genre=genre;
}
    public long getId(){ 
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String titre){
        this.titre=titre;
    }
    
    public String getRealisateur(){
        return this.realisateur;
    }
    public void setRealisateur(String realisateur){
        this.realisateur=realisateur;
    }

    public LocalDate getDateSortie(){
        return this.dateSortie;
    }
    public void setDateSortie(LocalDate date){
        this.dateSortie=date;
    }
    public Genrefilms getGenre(){
        return this.genre;
    }
    public void setGenre(Genrefilms genre){
        this.genre=genre;
    }
    public void setActeurs(Set<Acteur> acteurs) {
    this.acteurs = acteurs;
    }
    public Set<Acteur> getActeurs() {
    return this.acteurs;
    }
}

