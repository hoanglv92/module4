package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.validation.Validate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView getCreateUserFrom(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/create-user")
    public ModelAndView resultUserFrom(@Valid @ModelAttribute("user") User user, BindingResult result){
        ModelAndView modelAndViewResult=new ModelAndView("result");
        ModelAndView modelAndViewCreate=new ModelAndView("index");
        new Validate().validate(user,result);
        if (result.hasFieldErrors()){
            return modelAndViewCreate;
        }else {
            modelAndViewResult.addObject("username",user.getUserName());
            return modelAndViewResult;
        }
    }
}
