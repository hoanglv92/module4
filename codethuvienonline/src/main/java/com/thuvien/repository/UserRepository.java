package com.thuvien.repository;

import com.thuvien.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String username);
    Iterable<Users> findAllByUserNameStartsWith(String name);
    Page<Users> findAllByUserNameStartsWith(String name, Pageable pageable);
}
