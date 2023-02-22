package com.example.paintofheart.model.exceptions;

public class InvalidTicketIdException extends RuntimeException{
    public InvalidTicketIdException() {
        super("Invalid ticket id.");
    }
}
