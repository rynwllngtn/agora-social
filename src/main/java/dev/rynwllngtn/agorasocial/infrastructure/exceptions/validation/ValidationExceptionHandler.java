package dev.rynwllngtn.agorasocial.infrastructure.exceptions.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValid(MethodArgumentNotValidException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                                                                       "Erro em validação dos dados de " + e.getFieldErrorCount() + " campos!");
        Map<String, String> erros = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                            .forEach(erro -> {
                                String field = erro.getField();
                                String message = erro.getDefaultMessage();
                                erros.put(field, message);});

        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperty("fields", erros);
        return problemDetail;
    }

}