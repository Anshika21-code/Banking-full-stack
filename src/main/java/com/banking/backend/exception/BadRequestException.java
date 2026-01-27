package com.banking.backend.exception;

// 400 error

public class BadRequestException  extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
