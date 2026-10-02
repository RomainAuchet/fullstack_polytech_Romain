package org.polytech.films;

import java.util.List;

import org.polytech.dto.FilmCreationDto;
import org.polytech.dto.FilmDto;
import org.polytech.dto.FilmMapper;
import org.polytech.repository.ActeurRepository;
import org.polytech.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service 
public class FilmService {
    private final FilmRepository repository;
    private final ActeurRepository acteurRepository;

    public FilmService(FilmRepository repository, ActeurRepository acteurRepository) {
        this.repository = repository;
        this.acteurRepository = acteurRepository;
    }
    @Transactional
    public FilmDto createFilm(FilmCreationDto body){
        if (body.titre() == null) {
            throw new IllegalArgumentException("titre obligatoire");
        }
        Film saved = repository.save(FilmMapper.toEntity(body));
        return FilmMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public FilmDto getFilmById(Long id) {
        return repository.findById(id)
                .map(FilmMapper::toDto)
                .orElseThrow(() -> new FilmNotFoundException("Film non trouvé"));
    }

    @Transactional(readOnly = true)
    public List<FilmDto> getAllFilms() {
        return repository.findAll().stream()
                .map(FilmMapper::toDto)
                .toList();
    }
    @Transactional
    public FilmDto updateFilm(Long id, FilmCreationDto body) {
        Film film = repository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException("Film non trouvé"));
        film.setTitre(body.titre());
        film.setRealisateur(body.realisateur());
        film.setDateSortie(body.dateSortie());
        film.setGenre(body.genre());
        repository.save(film);
        return FilmMapper.toDto(film);
    }

    @Transactional
    public void DeleteFilm(Long id) {
        if (!repository.existsById(id)) {
            throw new FilmNotFoundException("Film non trouvé");
        }
        repository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public List<FilmDto> getFilmByTitre(String titre) {
        return repository.findByTitre(titre).stream()
                .map(FilmMapper::toDto)
                .toList();
    }
    
}
