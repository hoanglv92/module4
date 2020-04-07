package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface Blogservice {
    List<Blog> findAll() ;

    Blog findById(Long id);

    Blog save(Blog blog);

    Blog remove(Long id);
}
