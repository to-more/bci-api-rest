package com.bci.apirest.validators;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.exceptions.InvalidEmailException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class EmailValidator extends RegexValidator<UserDto>{


    private final String regex;

    public EmailValidator(@Value("${bci.validation.regex.email}") String regex) {
        this.regex = regex;
    }

    @Override
    String getRegex() {
        return regex;
    }

    @Override
    String getMatcher(UserDto input) {
        return input.email();
    }

    @Override
    RuntimeException getException() {
        return new InvalidEmailException("Formato de email incorrecto");
    }
}
