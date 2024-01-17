package com.bci.apirest.validators;

@FunctionalInterface
public interface BciValidator<I> {
    void validate(I input);
}
