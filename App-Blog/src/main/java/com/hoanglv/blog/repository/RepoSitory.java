package com.hoanglv.blog.repository;

import java.util.List;

public interface RepoSitory<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
