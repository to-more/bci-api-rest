package com.bci.apirest.validators;

import com.bci.apirest.dtos.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
    "bci.validation.regex.password=^(?!\\s*$).+\n"
})
public class PasswordValidatorTest {

    @Value("${bci.validation.regex.password}")
    String pattern;

    @Test
    public void correctFormatShouldNotThrowValidationException(){
        PasswordValidator passwordValidator = new PasswordValidator(pattern);
        assertDoesNotThrow(() -> passwordValidator
                .validate(new UserDto("Tom", "tom@gmail.com", "password", null)));
    }

    @Test
    public void invalidFormatShouldThrowValidationException(){
        PasswordValidator passwordValidator = new PasswordValidator(pattern);
        assertThrows(ValidationException.class, () -> passwordValidator
                .validate(new UserDto("Tom", "tom@mail.com", "", null)));
    }
}
