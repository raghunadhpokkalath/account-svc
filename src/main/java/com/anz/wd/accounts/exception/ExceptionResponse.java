package com.anz.wd.accounts.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    private String message;

    public ExceptionResponse(String message){
        this.message = message;

    }
}
