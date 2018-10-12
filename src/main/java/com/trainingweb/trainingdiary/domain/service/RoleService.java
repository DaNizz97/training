package com.trainingweb.trainingdiary.domain.service;

import com.trainingweb.trainingdiary.domain.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(String roleName);
}
