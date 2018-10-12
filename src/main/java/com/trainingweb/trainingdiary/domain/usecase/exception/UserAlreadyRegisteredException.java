package com.trainingweb.trainingdiary.domain.usecase.exception;

public class UserAlreadyRegisteredException extends RuntimeException {
    private String email;

    public UserAlreadyRegisteredException(String email) {
        super("User with email: '" + email + "' already registered!");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
