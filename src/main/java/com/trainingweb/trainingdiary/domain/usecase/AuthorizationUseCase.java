package com.trainingweb.trainingdiary.domain.usecase;

public interface AuthorizationUseCase {
    void login(String email, String password);
    void logout();
}
