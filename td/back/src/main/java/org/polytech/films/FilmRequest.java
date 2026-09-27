package org.polytech.films;

import java.time.LocalDate;

public class FilmRequest {

    private final String titre;
    private final String realisateur;
    private final LocalDate dateSortie;
    private final Genrefilms genre;

    public FilmRequest(String titre, String realisateur, LocalDate dateSortie, Genrefilms genre){
        this.titre=titre;
        this.realisateur=realisateur;
        this.dateSortie=dateSortie;
        this.genre=genre;
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




