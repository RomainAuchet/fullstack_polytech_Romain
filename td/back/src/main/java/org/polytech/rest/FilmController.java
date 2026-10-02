package org.polytech.rest;
import java.net.URI;
import java.util.List;

import org.polytech.dto.FilmCreationDto;
import org.polytech.dto.FilmDto;
import org.polytech.films.FilmService;
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
    public List<FilmDto> getAllFilms(){
        return service.getAllFilms();
    }

    @GetMapping ("/films/{id:\\d+}")
    public FilmDto getFilmbyID(@PathVariable Long id){
        return service.getFilmById(id);
    }

    @PostMapping ("/films")
    public ResponseEntity<FilmDto> createfilm(@RequestBody FilmCreationDto filmdto) {
    FilmDto saved = service.createFilm(filmdto);
    URI uri = ServletUriComponentsBuilder
    .fromCurrentRequest().path( "/{id}")
    .buildAndExpand(saved.id()).toUri();
    return ResponseEntity.created(uri).body(saved);
    }

    @PutMapping ("/films/{id:\\d+}")
    public ResponseEntity<FilmDto> updateFilm(@PathVariable Long id,@RequestBody FilmCreationDto film){
        FilmDto updated = service.updateFilm(id, film);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping ("/films/{id:\\d+}")
    public ResponseEntity<Void> DeleteFilm(@PathVariable Long id){
        service.DeleteFilm(id);
        return ResponseEntity.noContent().build();
    }

}