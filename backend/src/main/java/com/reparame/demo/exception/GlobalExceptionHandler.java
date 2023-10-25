package com.reparame.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {
// tratando error 415 Unsupported Media Type

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {

        HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        //String errorMessage = "Unsupported Media Type: " + ex.getMessage();
        String errorMessage = "Envie un formato json";

        return new ResponseEntity<>(errorMessage, status);
    }
    
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String errorMessage = ex.getReason();

        return new ResponseEntity<>(errorMessage, status);
    }

    //tratando los errores de campos del registro para que no se reciba campos nulos, vacio etc.
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidateExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldName, message);
        });

        return errors;
    }

}
