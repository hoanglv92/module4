package com.hoanglv.blog.service.impl;

import com.hoanglv.blog.model.BlogUser;
import com.hoanglv.blog.repository.BloguserRepository;
import com.hoanglv.blog.service.BloguserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BloguserServiceImpl implements BloguserService {
    @Autowired
    private BloguserRepository bloguserRepository;
    @Override
    public List<BlogUser> findAll() {
        return (List<BlogUser>) bloguserRepository.findAll();
    }



    @Override
    public BlogUser findOne(Long id) {
        return bloguserRepository.findOne(id);
    }

    @Override
    public void save(BlogUser blogUser) {
        bloguserRepository.save(blogUser);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void delete(Long id) {
        bloguserRepository.delete(id);
    }
}
