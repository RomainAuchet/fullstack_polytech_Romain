package org.polytech.films;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

public class Film {
    private final int id;
    private final String titre;
    private final String realisateur;
    private final LocalDate DateSortie;
    private final Genrefilms genre;

    public Film(int id, String titre, String realisateur, LocalDate DateSortie, Genrefilms genre){
        this.id=id;
        this.titre=titre;
        this.realisateur=realisateur;
        this.DateSortie=DateSortie;
        this.genre=genre;
}
    public int getId(){
        return this.id;
    }
    public String getTitre(){
        return this.titre;
    }
    public String getRealisateur(){
        return this.realisateur;
    }
    public LocalDate getDateSortie(){
        return this.DateSortie;
    }
    public Genrefilms getGenre(){
        return this.genre;
    }
}

