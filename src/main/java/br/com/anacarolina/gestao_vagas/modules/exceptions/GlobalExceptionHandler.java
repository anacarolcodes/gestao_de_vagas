package br.com.anacarolina.gestao_vagas.modules.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<String> handleUserFoundException(UserFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Usuário ou e-mail já cadastrado.");
    }
}
