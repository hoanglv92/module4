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
        model.addAttribute("blogUser",new BlogUser());
        return "create";
    }
    @PostMapping("/create-blog")
    public String save(@ModelAttribute ("blogUser") BlogUser blogUser,Model model){
        java.util.Date date=new java.util.Date();
        String dateDay=String.valueOf(date);
        System.out.println(blogUser.getName());
        System.out.println(blogUser.getTitle());
        blogUser.setTime(dateDay);
        bloguserService.save(blogUser);
        model.addAttribute("message","them thanh cong");
        return "/create";
    }
    @GetMapping("/delete-blog/{id}")
    public String getViewsFrom(@PathVariable Long id, Model model){
        BlogUser blogUser=bloguserService.findOne(id);
        System.out.println(blogUser.getTitle());
        System.out.println(blogUser.getId());
        model.addAttribute("blogUser",blogUser);
        return "view";
    }
    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute ("blogUser")BlogUser blogUser){
        System.out.println(blogUser.getId());
        bloguserService.delete(blogUser.getId());
        return "redirect:/home";
    }
    @GetMapping("/edit-blog/{id}")
    public String edit(@PathVariable Long id, Model model){
        BlogUser blogUser=bloguserService.findOne(id);
        if (blogUser!=null) {
            model.addAttribute("blogUser",blogUser);
            return "edit";
        }else {
            model.addAttribute("message","sua khong thanh cong.");
            return "edit";
        }
    }
    @PostMapping("/edit-blog")
    public String update(@ModelAttribute("blogUser") BlogUser blogUser, Model model){
        bloguserService.save(blogUser);
        model.addAttribute("blogUser",blogUser);
        model.addAttribute("massage","sua thanh cong");
        return "edit";
    }

}
