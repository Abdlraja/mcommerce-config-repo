package com.mcommandes.web.exceptions;

public class CommandeNotFoundException extends RuntimeException {
    public CommandeNotFoundException(String message) {
        super(message);
    }
}
