package com.codegym.service.impl;
import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIml implements UserService , UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User remove(Long id) {
        User user = userRepository.findById(id);
        userRepository.remove(id);
        return user;
    }

    @Override
    public User finfByName(String email) {
        return userRepository.findByName(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myDBUser = userRepository.findByName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(myDBUser.getRole().getAuthority()));
        org.springframework.security.core.userdetails.User
                userDetails = new org.springframework.security.core.userdetails.User(
                myDBUser.getEmail(),
                myDBUser.getPassword(),
                authorities
        );
        return userDetails;
    }
}
