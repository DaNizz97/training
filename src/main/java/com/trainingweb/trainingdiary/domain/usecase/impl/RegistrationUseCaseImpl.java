package com.trainingweb.trainingdiary.domain.usecase.impl;

import com.trainingweb.trainingdiary.domain.exception.ResourceNotFoundException;
import com.trainingweb.trainingdiary.domain.model.Role;
import com.trainingweb.trainingdiary.domain.model.User;
import com.trainingweb.trainingdiary.domain.service.RoleService;
import com.trainingweb.trainingdiary.domain.service.SecurityService;
import com.trainingweb.trainingdiary.domain.service.UserService;
import com.trainingweb.trainingdiary.domain.usecase.RegistrationUseCase;
import com.trainingweb.trainingdiary.domain.usecase.exception.UserAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RegistrationUseCaseImpl implements RegistrationUseCase {

    private UserService userService;
    private String userRole;
    private RoleService roleService;

    @Autowired
    public RegistrationUseCaseImpl(UserService userService, RoleService roleService,
                                   @Value("${roles.User}") String userRole) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRole = userRole;
    }

    @Override
    public void registerUser(String email, String password, String firstName, String lastName) {
        if (userService.findUserByEmail(email).isPresent()) {
            throw new UserAlreadyRegisteredException(email);
        }
        final Role role = roleService.findByRoleName(userRole).
                orElseThrow(() -> new ResourceNotFoundException("Role", "Role Name", userRole));
        final User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.addRole(role);
        userService.saveUser(user);
    }
}
