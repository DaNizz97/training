package com.trainingweb.trainingdiary.domain.usecase.impl;

import com.trainingweb.trainingdiary.domain.service.SecurityService;
import com.trainingweb.trainingdiary.domain.usecase.AuthorizationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationUseCaseImpl implements AuthorizationUseCase {

    private SecurityService securityService;

    @Autowired
    public AuthorizationUseCaseImpl(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public void login(String email, String password) {
        securityService.autoLogin(email, password);
    }

    @Override
    public void logout() {
        securityService.logout();
    }
}
