package com.codegym.repository;


import com.codegym.model.User;

import java.util.List;

public interface RepositoryUser<T> {
    List<T> findAll();
    User findById (Long id);
    void  save(T model);
    void remove(Long id);
    User findByName(String email);
}
