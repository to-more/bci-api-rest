package com.bci.apirest.usecase;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.mappers.PhoneMapperImpl;
import com.bci.apirest.mappers.UserMapper;
import com.bci.apirest.mappers.UserMapperImpl;
import com.bci.apirest.model.User;
import com.bci.apirest.repos.UserRepository;
import com.bci.apirest.usecases.CreateUserUseCase;
import com.bci.apirest.usecases.DuplicatedEmailException;
import com.bci.apirest.validators.EmailValidator;
import com.bci.apirest.validators.PasswordValidator;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateUserUseCaseTest {

    UserRepository repository = mock(UserRepository.class);
    UserMapper mapper = new UserMapperImpl(new PhoneMapperImpl());

    EmailValidator emailValidator = mock(EmailValidator.class);

    PasswordValidator passwordValidator = mock(PasswordValidator.class);

    CreateUserUseCase createUserUseCase = new CreateUserUseCase(repository, mapper, emailValidator, passwordValidator);

    private User getUser(){
        User user = new User();
        user.setName("Tom");
        user.setEmail("tom@mail.com");
        user.setPassword("password");
        user.setCreated(new Date());
        return user;
    }

    @Test
    public void shouldReturnCreatedUser(){
        UserDto userDto = new UserDto("Tom", "tom@mail.com", "password", null);
        when(repository.save(any(User.class))).thenReturn(getUser());
        Optional<User> userOptional = createUserUseCase.execute(userDto);
        assertNotEquals(Optional.empty(), userOptional);
        userOptional.ifPresent((user) -> {
            assertEquals("Tom", user.getName());
        });
    }

    @Test
    public void emailAlreadySavedShouldThrowException(){
        UserDto userDto = new UserDto("Tom", "tom@mail.com", "password", null);
        when(repository.findByEmail(any(String.class))).thenReturn(Optional.of(getUser()));
        DuplicatedEmailException exception = assertThrows(DuplicatedEmailException.class, () -> {
            createUserUseCase.execute(userDto);
        });
        assertEquals("El correo ya registrado tom@mail.com", exception.getMessage());
    }
}
