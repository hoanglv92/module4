
package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.UserLogin;
import com.codegym.service.Blogservice;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import  java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private Blogservice blogservice;

    @RequestMapping(value = "/blog",method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Blog> getListAllBlog(){
        return (List<Blog>) blogservice.findAll();
    }
    @GetMapping("/blog")
    public ModelAndView getHome( ){
        ModelAndView modelAndView=new ModelAndView("/blogs/all-blog");
        modelAndView.addObject("blog",getListAllBlog());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/blog/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
        blogservice.save(blog);
        return blog;
    }

    @RequestMapping(value = "/admin/blog/delete/{id}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog deleteBlog(@PathVariable Long id){
        Blog blog=blogservice.findById(id);
        blogservice.remove(id);
        return blog;
    }

    @RequestMapping(value = "/admin/blog/edit/{id}",method = RequestMethod.GET)
    public ModelAndView getEditFrom(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("/blogs/edit-blog");
        Blog blog=blogservice.findById(id);
        System.out.println(blog.getName());
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @RequestMapping(value = "/admin/blog/edit/{id}",method = RequestMethod.POST,
            produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog editblog(@PathVariable Long id , @RequestBody Blog blog){
        blog.setId(id);
        blogservice.save(blog);
        return blog;
    }
    @GetMapping("/home")
    public ModelAndView getIndex(){
        ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }
    @GetMapping("/signin")
    public ModelAndView getLogin(){
        ModelAndView modelAndView=new ModelAndView("login");
        modelAndView.addObject("user",new UserLogin());
        return modelAndView;
    }

}
