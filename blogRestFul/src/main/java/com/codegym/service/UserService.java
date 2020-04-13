package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll() ;

    User findById(Long id);

    User save(User user);

    User remove(Long id);

    User finfByName(String email);
}
