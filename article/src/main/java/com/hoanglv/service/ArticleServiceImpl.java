package com.hoanglv.service;

import com.hoanglv.model.Article;
import com.hoanglv.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements Articleservice<Article> {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findOne(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article.getId());
    }
}
