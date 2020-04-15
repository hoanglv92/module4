package com.codegym.service;


import com.codegym.model.UserLogin;


public interface Userservice {
    Iterable<UserLogin> findAll();
    UserLogin findById(Long id);
    void save(UserLogin userLogin);
    void remove(Long id);
    UserLogin findByName(String username);
}
