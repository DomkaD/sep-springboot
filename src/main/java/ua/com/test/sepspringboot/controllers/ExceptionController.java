package ua.com.test.sepspringboot.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> exceptionHandler(MethodArgumentNotValidException e){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("lalalala", "dadadada");
        ResponseEntity<String> response = new ResponseEntity<>(e.getFieldError().getDefaultMessage(), httpHeaders, HttpStatus.BAD_REQUEST);

        return response;
    }
}
