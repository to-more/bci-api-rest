package com.bci.apirest.dtos;

public record PhoneDto (
        String number,
        String cityCode,
        String countryCode) {
}
