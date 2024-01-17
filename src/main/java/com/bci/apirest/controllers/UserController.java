package com.bci.apirest.controllers;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.model.User;
import com.bci.apirest.usecases.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final CreateUserUseCase createUserUseCase;

    @Autowired
    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<User> create(@RequestBody @Valid UserDto userDto){
        return createUserUseCase.execute(userDto);
    }
}
