package org.fam.spring.demo.by.type.web;

import org.fam.spring.demo.by.type.services.DocumentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DocumentNotFound.class)
    public void docNotFound() {
        // Nothing to do
    }
}
