package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.Blogrepository;
import org.springframework.beans.factory.annotation.Autowired;


public class BlogserviceIml implements Blogservice {
    @Autowired
    Blogrepository blogrepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogrepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        Blog blog=blogrepository.findOne(id);
        if (blog==null){
            return null;
        }else {
            return blog ;
        }
    }

    @Override
    public void save(Blog blog) {
        blogrepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        Blog blog=blogrepository.findOne(id);
        blogrepository.delete(id);
    }
}
