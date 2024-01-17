package com.bci.apirest.dtos;

import jakarta.validation.constraints.Email;

import java.util.List;

public record UserDto(
        String name,
        String email,
        String password,
        List<PhoneDto> phones) {
}
