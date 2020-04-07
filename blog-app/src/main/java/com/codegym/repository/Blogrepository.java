package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface Blogrepository extends CrudRepository<Blog,Long> {
}
