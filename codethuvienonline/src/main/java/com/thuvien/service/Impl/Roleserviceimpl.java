package com.thuvien.service.Impl;

import com.thuvien.model.Role;
import com.thuvien.repository.RoleRepository;
import com.thuvien.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;

public class Roleserviceimpl implements Roleservice {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        Iterable<Role> roles=roleRepository.findAll();
        return roles;
    }

    @Override
    public Role findRoleById(Long id) {
        Role role=roleRepository.findOne(id);
        return role;
    }

    @Override
    public Role save(Role role) {
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role move(Role role) {
        roleRepository.delete(role);
        return role;
    }
}
