package com.abe.connections.validators;

import com.abe.connections.annotations.ValidUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username,
                           ConstraintValidatorContext constraintValidatorContext) {
        return username != null &&
                username.matches("^[a-zA-Z0-9_. -]{3,50}$");
    }
}
