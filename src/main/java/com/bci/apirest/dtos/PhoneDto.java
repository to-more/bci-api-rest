package com.bci.apirest.dtos;

import java.util.Date;

public record PhoneDto (
        String number,
        String cityCode,
        String countryCode) {
}
