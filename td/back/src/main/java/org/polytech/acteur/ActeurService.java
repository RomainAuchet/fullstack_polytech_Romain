package org.polytech.acteur;

import java.util.List;

import org.polytech.dto.ActeurCreationDto;
import org.polytech.dto.ActeurDto;
import org.polytech.dto.ActeurMapper;
import org.polytech.films.FilmNotFoundException;
import org.polytech.repository.ActeurRepository;
import org.polytech.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class ActeurService {
    private final ActeurRepository repository;
    private final FilmRepository filmrepository;

    public ActeurService(ActeurRepository repository, FilmRepository FilmRepository) {
        this.repository = repository;
        this.filmrepository = FilmRepository;
    }
    @Transactional
    public ActeurDto createActeur(ActeurCreationDto body){
        if (body.nom() == null) {
            throw new IllegalArgumentException("nom obligatoire");
        }
        Acteur saved = repository.save(ActeurMapper.toEntity(body));
        return ActeurMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public ActeurDto getActeurById(Long id) {
        return repository.findById(id)
                .map(ActeurMapper::toDto)
                .orElseThrow(() -> new FilmNotFoundException("Acteur non trouvé"));
    }

    @Transactional(readOnly = true)
    public List<ActeurDto> getAllActeurs() {
        return repository.findAll().stream()
                .map(ActeurMapper::toDto)
                .toList();
    }
    @Transactional
    public ActeurDto updateActeur(Long id, ActeurCreationDto body) {
        Acteur acteur = repository.findById(id)
                .orElseThrow(() -> new ActeurNotFoundException("Acteur non trouvé"));
        acteur.setNom(body.nom());
        acteur.setPrenom(body.prenom());
        repository.save(acteur);
        return ActeurMapper.toDto(acteur);
    }

    @Transactional
    public void DeleteActeur(Long id) {
        if (!repository.existsById(id)) {
            throw new ActeurNotFoundException("Acteur non trouvé");
        }
        repository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public List<ActeurDto> getActeurByNom(String nom) {
        return repository.findByNom(nom).stream()
                .map(ActeurMapper::toDto)
                .toList();
    }
}
