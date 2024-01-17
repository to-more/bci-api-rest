package com.bci.apirest.validators;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.exceptions.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
    "bci.validation.regex.email=^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$"
})
public class EmailValidatorTest {

    @Value("${bci.validation.regex.email}")
    String pattern;

    @Test
    public void correctFormatShouldNotThrowValidationException(){
        EmailValidator emailValidator = new EmailValidator(pattern);
        assertDoesNotThrow(() -> emailValidator
                .validate(new UserDto("Tom", "tom@gmail.com", "password", null)));
    }

    @Test
    public void invalidFormatShouldThrowValidationException(){
        EmailValidator emailValidator = new EmailValidator(pattern);
        assertThrows(ValidationException.class, () -> emailValidator
                .validate(new UserDto("Tom", "tom@gmail", "password", null)));
    }
}
