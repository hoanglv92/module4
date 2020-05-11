package com.hoanglv.controller;

import com.hoanglv.model.Article;
import com.hoanglv.service.Articleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ArticleController {
    @Autowired
    private Articleservice articleservice;
//
//    String url="https://api.hnpwa.com/v0/news/1.json";

    @GetMapping("/api/home")
    public List getHome(){
        return articleservice.findAll();
    }
    @PostMapping("/api/home")
    public ResponseEntity<List<Article>> save(@RequestBody Article article){
        articleservice.save(article);
        System.out.println(article.getId());
        System.out.println(article.getUrl());
        System.out.println(article.getTitle());
        return new ResponseEntity<List<Article>>(getHome(),HttpStatus.OK);
    }
    @PutMapping("/api/add")
    public ResponseEntity<List<Article>> addArticle(@RequestBody Article article){
        articleservice.save(article);
        return new ResponseEntity<List<Article>>(getHome(),HttpStatus.CREATED);
    }
    @PostMapping("/api/delete")
    public ResponseEntity<List<Article>> deleteArticle(@RequestBody Long id){
        Article article= (Article) articleservice.findOne(id);
        articleservice.delete(article);
        return new ResponseEntity<List<Article>>(getHome(),HttpStatus.OK);
    }
}
