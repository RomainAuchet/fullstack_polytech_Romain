package org.polytech.films;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<Film> createfilm(@RequestBody FilmRequest film) {
    Film saved = service.createFilm(film.getTitre(),film.getRealisateur(),film.getDateSortie(), film.getGenre());
    URI uri = ServletUriComponentsBuilder
    .fromCurrentRequest().path( "/{id}")
    .buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(uri).body(saved);
    }

    @PutMapping ("/films/{id:\\d+}")
    public ResponseEntity<Film> updateFilm(@PathVariable int id,@RequestBody FilmRequest film){
        Film updated = service.Updatefilm(id, film);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping ("/films/{id:\\d+}")
    public ResponseEntity<Void> DeleteFilm(@PathVariable int id){
        service.Deletefilm(id);
        return ResponseEntity.noContent().build();
    }

}