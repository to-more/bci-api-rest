package com.bci.apirest.validators;

import com.bci.apirest.dtos.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator extends RegexValidator<UserDto> {

    private final String regex;

    public PasswordValidator(@Value("${bci.validation.regex.password}") String regex) {
        this.regex = regex;
    }

    @Override
    String getRegex() {
        return regex;
    }

    @Override
    String getMatcher(UserDto input) {
        return input.password();
    }

    @Override
    RuntimeException getException() {
        return new InvalidPasswordException("Password invalida");
    }
}
