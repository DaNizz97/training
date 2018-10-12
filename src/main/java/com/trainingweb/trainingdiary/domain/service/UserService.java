package com.trainingweb.trainingdiary.domain.service;

import com.trainingweb.trainingdiary.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email);
    User findUserById(Long userId);
    void saveUser(User user);
    boolean isAdmin();
    Optional<User> getCurrentAuthUser();
    List<User> getAllUsers();
    void deleteUser(Long userId);
}
