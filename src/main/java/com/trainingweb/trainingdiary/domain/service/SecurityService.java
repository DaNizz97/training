package com.trainingweb.trainingdiary.domain.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

    void logout();
}
