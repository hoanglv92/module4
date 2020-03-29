package com.hoanglv.blog.service;

import com.hoanglv.blog.model.BlogUser;

import java.util.List;

public interface BloguserService {
    List<BlogUser> findAll() ;

    BlogUser findById(Long id);

    void save(BlogUser customer);

    void remove(Long id);
}
