package com.example.paintofheart.model.exceptions;

public class InvalidCartIdException extends RuntimeException{
    public InvalidCartIdException() {
        super("Invalid cart id.");
    }
}
