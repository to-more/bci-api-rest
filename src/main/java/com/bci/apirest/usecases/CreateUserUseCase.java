package com.bci.apirest.usecases;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.exceptions.DuplicatedEmailException;
import com.bci.apirest.mappers.UserMapper;
import com.bci.apirest.model.User;
import com.bci.apirest.repos.UserRepository;
import com.bci.apirest.validators.EmailValidator;
import com.bci.apirest.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateUserUseCase implements UseCase<UserDto, Optional<User>> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    @Autowired
    public CreateUserUseCase(
         UserRepository userRepository,
         UserMapper userMapper,
         EmailValidator emailValidator,
         PasswordValidator passwordValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public Optional<User> execute(UserDto userDto){
        emailValidator.validate(userDto);
        passwordValidator.validate(userDto);
        userRepository.findByEmail(userDto.email())
            .ifPresent(user -> {
                throw new DuplicatedEmailException("El correo ya registrado " + user.getEmail());
            });
        return userMapper
                .dtoToModel(userDto)
                .map(userRepository::save);
    }
}
