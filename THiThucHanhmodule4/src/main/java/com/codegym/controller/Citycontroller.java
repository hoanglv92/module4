package com.codegym.controller;

import com.codegym.service.CityService;
import com.codegym.service.Countryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Citycontroller {
    @Autowired
    CityService cityService;
    @Autowired
    Countryservice countryservice;
    @GetMapping("/")
    public String getAllCity(Model model){
        
        return "";
    }
}
