package com.bci.apirest.exceptions;

public class InvalidPasswordException extends ValidationException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
