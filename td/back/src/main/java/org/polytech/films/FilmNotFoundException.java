package org.polytech.films;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException (String message) {
        super (message);
    }
}
