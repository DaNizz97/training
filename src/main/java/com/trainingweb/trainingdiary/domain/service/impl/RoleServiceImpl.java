package com.trainingweb.trainingdiary.domain.service.impl;

import com.trainingweb.trainingdiary.domain.model.Role;
import com.trainingweb.trainingdiary.repository.RoleRepository;
import com.trainingweb.trainingdiary.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
