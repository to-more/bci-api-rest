package com.bci.apirest.exceptions;

public class DuplicatedEmailException extends ValidationException {
    public DuplicatedEmailException(String message){
        super(message);
    }
}
