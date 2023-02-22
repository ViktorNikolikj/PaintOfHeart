package com.example.paintofheart.model.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException() {
        super("Invalid customer id exception.");
    }
}
