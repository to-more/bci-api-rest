package com.bci.apirest.controllers;

import com.bci.apirest.validators.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ErrorControllerAdviceTest {

    @Test
    public void shouldReturnErrorResponseWhenCallHandleDuplicatedEmailException(){
        ErrorControllerAdvice errorControllerAdvice = new ErrorControllerAdvice();
        ResponseEntity<ErrorResponse> errorResponse = errorControllerAdvice.handleDuplicatedEmailException(new ValidationException("Error"));
        assertEquals("Error", errorResponse.getBody().getMessage());
        assertEquals(HttpStatus.CONFLICT, errorResponse.getStatusCode());
    }
}
