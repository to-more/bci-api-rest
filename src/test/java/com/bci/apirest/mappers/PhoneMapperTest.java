package com.bci.apirest.mappers;

import com.bci.apirest.dtos.PhoneDto;
import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.model.Phone;
import com.bci.apirest.model.User;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneMapperTest {

    @Test
    public void shouldMapUserDtoToUser(){
        Phone phone = new PhoneMapperImpl()
                .dtoToModel(new PhoneDto("12345678", "11", "54"));
        assertEquals("11", phone.getCityCode());
        assertEquals("54", phone.getCountryCode());
        assertEquals("12345678", phone.getNumber());
    }
}
