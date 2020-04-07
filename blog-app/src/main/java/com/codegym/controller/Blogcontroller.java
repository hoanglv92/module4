package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.Blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Blogcontroller {
    @Autowired
    private Blogservice blogService;

    @GetMapping("/home")
    public String getHome(Model model){
        List<Blog> blogs=(List<Blog>) blogService.findAll();
        model.addAttribute("blog",blogs);
        return "home";
    }
    @GetMapping("/create-blog")
    public String getCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create-blog")
    public String save(@ModelAttribute("blog") Blog blog, Model model){
        java.util.Date date=new java.util.Date();
        String dateDay=String.valueOf(date);
        blog.setTime(dateDay);
        System.out.println(blog.getName());
        System.out.println(blog.getTitle());
        blogService.save(blog);
        model.addAttribute("message","them thanh cong");
        return "/create";
    }
    @GetMapping("/edit-blog/{id}")
    public String edit(@PathVariable Long id, Model model){
        Blog blog=blogService.findById(id);
        if (blog!=null) {
            model.addAttribute("blog",blog);
        }else {
            model.addAttribute("message","sua khong thanh cong.");
            return "edit";
        }
        return "edit";
    }
    @PostMapping("/edit-blog")
    public String update(@ModelAttribute("blog") Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute(model);
        model.addAttribute("massage","sua thanh cong");
        return "edit";
    }
    @GetMapping("/view-blog/{id}")
    public String view(@PathVariable Long id,Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog",blog);
        return "view";

    }
    @GetMapping("/delete-blog/{id}")
    public ModelAndView delete(@PathVariable Long id){
        Blog blog=blogService.findById(id);
//        if(blog !=null){
        ModelAndView modelAndView=new ModelAndView("delete");
        modelAndView.addObject("blog",blog);
        System.out.println(blog.getId());
        return modelAndView;
//        }else {
//            ModelAndView modelAndView=new ModelAndView("error.404");
//            return modelAndView;

    }
    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Blog blog, Model model){
        blogService.remove(blog.getId());
        model.addAttribute("massage","xoa thanh cong");
        return "home";
    }

}
