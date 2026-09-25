package org.polytech.films;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class FilmController {
    private final FilmService service;

    public FilmController(FilmService service){
        this.service=service;
    }
    @GetMapping ("/films")
    public List<Film> getALLFilm(){
        return service.getALLFilm();
    }

    @GetMapping ("/films/{id:\\d+}")
    public Film getFilmbyID(@PathVariable int id){
        return service.getFilmbyID(id);
    }

    @PostMapping ("/films")
    public ResponseEntity<String> createfilm(@RequestBody Film film){
        services.createfilm(film.getTitre(),film.getRealisateur(),film.getDateSortie(), film.getDateSortie());
        return 
    }
    }

