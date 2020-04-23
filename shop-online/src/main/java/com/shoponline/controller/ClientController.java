package com.shoponline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView=new ModelAndView("client/view/index");
        return modelAndView;
    }
}
