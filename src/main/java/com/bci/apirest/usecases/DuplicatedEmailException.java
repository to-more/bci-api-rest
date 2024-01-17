package com.bci.apirest.usecases;

import com.bci.apirest.validators.ValidationException;

public class DuplicatedEmailException extends ValidationException {
    public DuplicatedEmailException(String message){
        super(message);
    }
}
