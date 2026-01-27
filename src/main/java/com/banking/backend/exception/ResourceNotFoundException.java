package com.banking.backend.exception;

// 404 error

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
