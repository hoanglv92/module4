package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private Blogservice blogservice;
    @RequestMapping(value = "/blog",method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog>getBlogList(){
        return blogservice.findAll();
    }
    @GetMapping("/blog")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("blogs/all-blogs");
        modelAndView.addObject("blog", getBlogList());
        return modelAndView;
    }
    @RequestMapping(value = "/blog/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Blog> blogResponseEntity(@PathVariable("id") long id){
        Blog blog=blogservice.findById(id);
        if (blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/blog/create")
    public ModelAndView getCreateFrom(){
        ModelAndView modelAndView=new ModelAndView("/blogs/new-blog");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @RequestMapping(value = "/blog/create",method = RequestMethod.POST,
            produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog createBlog(@RequestBody Blog blog){
        System.out.println(blog.getName());
        System.out.println(blog.getContent());
       return  blogservice.save(blog);
    }

    @RequestMapping(value = "/blog/delete/{id}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog deleteBlog(@PathVariable Long id){
        return blogservice.remove(id);
    }

    @RequestMapping(value = "/blog/edit/{id}",method = RequestMethod.GET)
    public ModelAndView getEditFrom(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("/blogs/edit-blog");
        Blog blog=blogservice.findById(id);
        System.out.println(blog.getName());
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @RequestMapping(value = "/blog/edit/{id}",method = RequestMethod.POST,
            produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog editblog(@PathVariable Long id , @RequestBody Blog blog){
        blog.setId(id);
        return blogservice.save(blog);
    }

}
