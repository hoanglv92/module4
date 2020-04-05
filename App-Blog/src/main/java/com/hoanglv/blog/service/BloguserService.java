package com.hoanglv.blog.service;

import com.hoanglv.blog.model.BlogUser;
import java.util.List;

public interface BloguserService {

    List<BlogUser> findAll() ;

    BlogUser findOne(Long id);


    void save(BlogUser customer);

    void remove(Long id);
    void delete(Long id);
}
