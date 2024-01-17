package com.bci.apirest.controllers;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.usecases.CreateUserUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    private MockMvc mvc;

    CreateUserUseCase createUserUseCase = mock(CreateUserUseCase.class);

    private final UserController userController = new UserController(createUserUseCase);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(new ErrorControllerAdvice()).build();
    }

    @Test
    public void shouldReturn201WhenAfterUserCreation() throws Exception {
        UserDto userDto = new UserDto("Tom", "tom@mail.com", "password", null);
        mvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isCreated()).andReturn().getResponse();
    }
}
