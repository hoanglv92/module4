package com.thuvien.service;

import com.thuvien.model.Role;


public interface Roleservice {
    Iterable<Role> findAll();
    Role findRoleById(Long id);
    Role save(Role role);
    Role move(Role role);
}
