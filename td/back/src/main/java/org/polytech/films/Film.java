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
    public int Getid(){
        return this.id;
    }
    public String Gettitre(){
        return this.titre;
    }
    public String Getrealisateur(){
        return this.realisateur;
    }
    public LocalDate GetDateSortie(){
        return this.DateSortie;
    }
    public Genrefilms Getgenre(){
        return this.genre;
    }
}

