package com.thuvien.service;

import com.thuvien.model.Book;
import com.thuvien.model.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Userservice {
    Iterable<Users> findAllUsers();
    Users findUserById(Long id);
    Users save(Users users);
    Users move(Users users);
    Users findUserByUserName(String username);
    Page<Users> getAllUsers(String startWithText, int size, int page);
}
