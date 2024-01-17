package com.bci.apirest.mappers;

import com.bci.apirest.dtos.PhoneDto;
import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.model.User;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    @Test
    public void shouldMapUserDtoToUser(){
        Optional<User> userOptional = new UserMapperImpl(new PhoneMapperImpl())
                .dtoToModel(new UserDto("Tom", "tom@mail.com", "password",
                        List.of(new PhoneDto("123", "11", "54"))));
        assertNotEquals(Optional.empty(), userOptional);
        userOptional.ifPresent((user) ->{
            assertEquals("tom@mail.com", user.getEmail());
            assertEquals("Tom", user.getName());
            assertEquals("password", user.getPassword());
            assertNotEquals("", user.getId());
            assertEquals(true, user.getActive());
            Date now = new Date();
            long time = now.getTime() - user.getCreated().getTime();
            assertTrue(time < Duration.ofMillis(1000).toMillis());
        });
    }
}
