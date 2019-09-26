package com.anz.wd.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
   @ExceptionHandler(RecordNotFoundException.class)
    public final ExceptionResponse handleNotFound(Exception ex) {
        return new ExceptionResponse(ex.getMessage());
    }
}
