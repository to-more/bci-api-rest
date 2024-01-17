package com.bci.apirest.validators;

import java.util.Optional;

@FunctionalInterface
public interface BciValidator<I> {
    void validate(I input);
}
