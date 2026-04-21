package dev.rynwllngtn.agorasocial.infrastructure.exceptions.database;

import dev.rynwllngtn.agorasocial.infrastructure.exceptions.database.DatabaseException.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class DatabaseExceptionHandler {

    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ProblemDetail objectNotFound(ObjectNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                                                                       e.getMessage());

        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}