package com.example.paintofheart.model.exceptions;

public class InvalidArtistIdException extends RuntimeException{
    public InvalidArtistIdException() {
        super("Invalid artist id.");
    }
}
