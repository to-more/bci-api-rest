package com.bci.apirest.validators;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
