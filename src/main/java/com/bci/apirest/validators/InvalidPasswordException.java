package com.bci.apirest.validators;

public class InvalidPasswordException extends ValidationException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
