package org.polytech.films;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Film {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false, length=200)
    private  String titre;
    private  String realisateur;
    private  LocalDate dateSortie;
    private Genrefilms genre;

    public Film(long id, String titre, String realisateur, LocalDate dateSortie, Genrefilms genre){
        this.id=id;
        this.titre=titre;
        this.realisateur=realisateur;
        this.dateSortie=dateSortie;
        this.genre=genre;
}
    public long getId(){
        return this.id;
    }
    public String getTitre(){
        return this.titre;
    }
    public String getRealisateur(){
        return this.realisateur;
    }
    public LocalDate getDateSortie(){
        return this.dateSortie;
    }
    public Genrefilms getGenre(){
        return this.genre;
    }
}

