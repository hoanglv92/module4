package com.hoanglv.service;

import java.util.List;

public interface Articleservice<Article> {
    List<Article> findAll();
    Article findOne(Long id);
    void save (Article article);
    void delete(Article article);
}
