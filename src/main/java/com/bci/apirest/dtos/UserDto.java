package com.bci.apirest.dtos;

import java.util.List;

public record UserDto(
        String name,
        String email,
        String password,
        List<PhoneDto> phones) {
}
