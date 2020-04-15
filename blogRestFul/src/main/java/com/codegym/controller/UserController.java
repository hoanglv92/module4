package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    HttpSession httpSession;

    @GetMapping("/signin")
    public String getsigninFrom(Model model, @CookieValue (defaultValue = "") User user){
        model.addAttribute("users",new User());
        return "login";
    }
//    @PostMapping("signin")
//    public String getHome(){
//        return ""
//    }
}
