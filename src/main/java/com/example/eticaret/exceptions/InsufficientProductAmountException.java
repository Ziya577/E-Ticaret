package com.example.eticaret.exceptions;

public class InsufficientProductAmountException extends RuntimeException{

    public InsufficientProductAmountException(String message) {
        super(message);
    }
}
