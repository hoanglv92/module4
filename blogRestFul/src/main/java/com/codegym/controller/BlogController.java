package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private Blogservice blogservice;
    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listResponseEntity(){
        List<Blog> blogs=blogservice.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @RequestMapping(value = "/blog/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Blog> blogResponseEntity(@PathVariable("id") long id){
        Blog blog=blogservice.findById(id);
        if (blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/blog",method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder uriComponentsBuilder){
       blogservice.save(blog);
       HttpHeaders headers=new HttpHeaders();
       headers.setLocation(uriComponentsBuilder.path("/blog/{id}").buildAndExpand(blog.getId()).toUri());
       return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/blog/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") long id,@RequestBody Blog blog){
      Blog blog1= blogservice.findById(id);
      if (blog1==null){
          return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
      }
      blog1.setId(blog.getId());
      blog1.setName(blog.getName());
      blog1.setContent(blog.getContent());
      blog1.setTime(blog.getTime());
      blog1.setTitle(blog.getTitle());
      blogservice.save(blog1);
      return new ResponseEntity<Blog>(blog1,HttpStatus.OK);
    }
    @RequestMapping(value = "/blog/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") long id){
        Blog blog=blogservice.findById(id);
        if(blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blogservice.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);

     }

}
