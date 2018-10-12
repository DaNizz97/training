package com.trainingweb.trainingdiary.domain.usecase;

public interface RegistrationUseCase {
    void registerUser(String email, String password, String firstName, String lastName);
}
