package com.example.paintofheart.model.exceptions;

public class InvalidEventIdException extends RuntimeException{
    public InvalidEventIdException() {
        super("Invalid event id.");
    }
}
