package com.example.eticaret.exceptions;

public class ProductNotAvailableException extends RuntimeException{


    public ProductNotAvailableException(String message) {
        super(message);
    }
}
