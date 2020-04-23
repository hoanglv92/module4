package com.thuvien.service.Impl;

import com.thuvien.model.Users;
import com.thuvien.repository.UserRepository;
import com.thuvien.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserservicceImpl implements Userservice, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<Users> findAllUsers() {
        Iterable<Users> listUsers= userRepository.findAll();
        return listUsers;
    }

    @Override
    public Users findUserById(Long id) {
        Users users=userRepository.findOne(id);
        return users;
    }

    @Override
    public Users save(Users users) {
        userRepository.save(users);
        return users;
    }

    @Override
    public Users move(Users users) {
        userRepository.delete(users);
        return users;
    }



    @Override
    public Users findUserByUserName(String username) {
        Users listUsers=userRepository.findByUserName(username);
        return listUsers;
    }

    @Override
    public Page<Users> getAllUsers(String startWithText, int size, int page) {
        Pageable pageable= new PageRequest(page,size, Sort.Direction.DESC,"userName");
        if (startWithText.isEmpty()){
            return this.userRepository.findAll(pageable);
        }else {
            return this.userRepository.findAllByUserNameStartsWith(startWithText,pageable);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=userRepository.findByUserName(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(users.getRole().getAuthority()));
        User user=new User(users.getUserName(),users.getPassWord(),authorities);
        return user;
    }
}
