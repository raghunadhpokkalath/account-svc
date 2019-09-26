package com.anz.wd.accounts.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String message){
        super(message);
    }

}
