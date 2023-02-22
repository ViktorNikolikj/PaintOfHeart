package com.example.paintofheart.model.exceptions;

public class InvalidSeatIdException extends RuntimeException{
    public InvalidSeatIdException() {
        super("Invalid seat id.");
    }
}
