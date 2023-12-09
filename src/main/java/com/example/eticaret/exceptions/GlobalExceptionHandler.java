package com.example.eticaret.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
 @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }
    @ExceptionHandler(UserDetailsNotFoundException.class)
    public ResponseEntity<String> handleUserDetailsNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}
    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<String> handleProductNotAvailableException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InsufficientProductAmountException.class)
    public ResponseEntity<String> handleInsufficientProductAmountException(Exception e) {
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(e.getMessage());

    }
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(Exception e) {
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.SEE_OTHER).body(e.getMessage());


    }

}