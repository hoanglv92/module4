package com.hoanglv.blog.controller;

import com.hoanglv.blog.model.BlogUser;
import com.hoanglv.blog.service.BloguserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class BlogUserController {
    @Autowired
    BloguserService bloguserService;

    @GetMapping("/home")
   public String getHome(Model model){
        List<BlogUser> blogUser=bloguserService.findAll();
        model.addAttribute("blogUser",blogUser);
        return "home";
    }
    @GetMapping("/create-blog")
    public String getCreate(Model model){
        model.addAttribute("bloguser",new BlogUser());
        return "create";
    }
    @PostMapping("/create-blog")
    public String save(@ModelAttribute ("blogUser") BlogUser blogUser,Model model){
        java.util.Date date=new java.util.Date();
        String dateDay=String.valueOf(date);
        blogUser.setTime(dateDay);
        bloguserService.save(blogUser);
        model.addAttribute("message","them thanh cong");
        return "/create";
    }
    @GetMapping("/edit-blog/{id}")
    public String edit(@PathVariable Long id, Model model){
        BlogUser blogUser=bloguserService.findById(id);
        if (blogUser!=null) {
            model.addAttribute("blogUser",blogUser);
        }else {
            model.addAttribute("message","sua khong thanh cong.");
            return "edit";
        }
        return "edit";
    }
    @PostMapping("/edit-blog")
    public String update(@ModelAttribute ("bloguser")BlogUser blogUser, Model model){
        bloguserService.save(blogUser);
        model.addAttribute(model);
        model.addAttribute("massage","sua thanh cong");
        return "edit";
    }

}
