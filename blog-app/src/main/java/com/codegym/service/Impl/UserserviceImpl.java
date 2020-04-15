package com.codegym.service.Impl;

import com.codegym.model.UserLogin;
import com.codegym.repository.UserRepository;
import com.codegym.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserserviceImpl implements Userservice , UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<UserLogin> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserLogin findById(Long id) {
        UserLogin userLogin=userRepository.findOne(id);
        if (userLogin==null){
            return null;
        }
        return userLogin;
    }

    @Override
    public void save(UserLogin user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        UserLogin user=userRepository.findOne(id);
        if (user==null){
            System.out.println("user ko ton tai");
        }else {
            userRepository.delete(id);
        }
    }

    @Override
    public UserLogin findByName(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin dbUser=userRepository.findUserByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(dbUser.getRole().getAuthority()));
        org.springframework.security.core.userdetails.User
                userDetails = new org.springframework.security.core.userdetails.User(
                dbUser.getUsername(),
                dbUser.getPassword(),
                authorities
        );
        return userDetails;
    }

}
