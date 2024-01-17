package com.bci.apirest.validators;


public class InvalidEmailException extends ValidationException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
