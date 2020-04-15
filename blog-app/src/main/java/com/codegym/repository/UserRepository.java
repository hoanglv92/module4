package com.codegym.repository;

import com.codegym.model.UserLogin;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserLogin,Long> {
    UserLogin findUserByUsername(String username);
}
