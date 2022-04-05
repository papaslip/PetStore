package com.example.pets.controller;

import com.example.pets.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;


@RestControllerAdvice
public class ExController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> idNotFoundHandleException (IdNotFoundException ex) {
        return new ResponseEntity<Object>("Not found Id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> iOHandleException (IOException ex) {
        return new ResponseEntity<Object>("Something went wrong when upload file", HttpStatus.BAD_REQUEST);
    }

}
