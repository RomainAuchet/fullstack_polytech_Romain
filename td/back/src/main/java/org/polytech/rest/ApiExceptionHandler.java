package org.polytech.rest;

import java.net.URI;
import java.time.Instant;

import org.polytech.films.FilmNotFoundException;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

@ExceptionHandler(IllegalArgumentException.class)
public ProblemDetail handle(IllegalArgumentException e) {
    ProblemDetail pb = ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());
    pb.setTitle("Film invalide");
    pb.setType(URI.create(
    "https://api.polytech.fr/errors/films" ));
    pb.setProperty("timestamp", Instant.now());
    return pb;
}
@ExceptionHandler(FilmNotFoundException.class)
public ProblemDetail handle (FilmNotFoundException e) {
    ProblemDetail pb = ProblemDetail.forStatusAndDetail(NOT_FOUND, e.getMessage());
    pb.setTitle("Id invalide");
    pb.setType(URI.create(
    "https://api.polytech.fr/errors/films" ));
    pb.setProperty("timestamp", Instant.now());
    return pb;
}
}

