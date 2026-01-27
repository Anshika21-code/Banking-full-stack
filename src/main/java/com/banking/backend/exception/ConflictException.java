package com.banking.backend.exception;

// 409 error

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
