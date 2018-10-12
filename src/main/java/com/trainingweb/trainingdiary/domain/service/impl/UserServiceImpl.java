package com.trainingweb.trainingdiary.domain.service.impl;

import com.trainingweb.trainingdiary.domain.exception.ResourceNotFoundException;
import com.trainingweb.trainingdiary.domain.model.User;
import com.trainingweb.trainingdiary.domain.service.SecurityService;
import com.trainingweb.trainingdiary.repository.UserRepository;
import com.trainingweb.trainingdiary.domain.service.RoleService;
import com.trainingweb.trainingdiary.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleService roleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SecurityService securityService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder encoder, SecurityService securityService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = encoder;
        this.securityService = securityService;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public Optional<User> getCurrentAuthUser() {
        return findUserByEmail(securityService.findLoggedInUsername());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
    }
}
