package org.polytech.films;

import java.net.URI;
import java.time.Instant;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
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
}

