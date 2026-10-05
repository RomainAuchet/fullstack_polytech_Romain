package org.polytech.rest;
import java.net.URI;
import java.util.List;

import org.polytech.acteur.ActeurService;
import org.polytech.dto.ActeurCreationDto;
import org.polytech.dto.ActeurDetailDto;
import org.polytech.dto.ActeurDto;
import org.polytech.dto.FilmDto;
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
public class ActeurController {
    private final ActeurService service;

    public ActeurController(ActeurService service){
        this.service=service;
    }
    @GetMapping ("/acteurs")
    public List<ActeurDto> getAllActeurs(){
        return service.getAllActeurs();
    }

    @GetMapping ("/acteurs/{id:\\d+}")
    public ActeurDetailDto getActeurbyID(@PathVariable Long id){
        return service.getActeurById(id);
    }

    @PostMapping ("/acteurs")
    public ResponseEntity<ActeurDto> createActeur(@RequestBody ActeurCreationDto acteurdto) {
    ActeurDto saved = service.createActeur(acteurdto);
    URI uri = ServletUriComponentsBuilder
    .fromCurrentRequest().path( "/{id}")
    .buildAndExpand(saved.id()).toUri();
    return ResponseEntity.created(uri).body(saved);
    }

    @PutMapping ("/acteurs/{id:\\d+}")
    public ResponseEntity<ActeurDto> updateActeur(@PathVariable Long id,@RequestBody ActeurCreationDto acteur){
        ActeurDto updated = service.updateActeur(id, acteur);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping ("/acteurs/{id:\\d+}")
    public ResponseEntity<Void> DeleteActeur(@PathVariable Long id){
        service.DeleteActeur(id);
        return ResponseEntity.noContent().build();
    }
           
    @GetMapping ("/acteurs/{id:\\d+}/films")
   public List<FilmDto> getActeurbyIdwithDetail(@PathVariable Long id){
      return service.getFilmFromActeurById(id);
    }
        
        
}

