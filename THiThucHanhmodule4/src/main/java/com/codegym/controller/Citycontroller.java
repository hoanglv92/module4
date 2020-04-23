package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.Countryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Citycontroller {
    @Autowired
    CityService cityService;
    @Autowired
    Countryservice countryservice;
    @GetMapping("/")
    public String getAllCity(Model model){
        List<City> cityList=cityService.findAll();
        model.addAttribute("cityList",cityList);
        return "allcity";
    }



    @ModelAttribute("listCountry")
    public List<Country> getListCountry(){
        List<Country> countryList=countryservice.findAll();
        return countryList;
    }
    @GetMapping("/city/views/{id}")
    public String getFromViewCity(Model model, @PathVariable Long id){
        City cityview=cityService.findById(id);
        model.addAttribute("cityview",cityview);
        return "view";
    }


    @GetMapping("/city/edit/{id}")
    public String getFromEditCity(Model model, @PathVariable Long id){
        City cityEdit=cityService.findById(id);
        model.addAttribute("cityEdit",cityEdit);
        return "Edit";
    }
    @PostMapping("/city/edit/")
    public String saveCity(Model model,@ModelAttribute City city){
        cityService.save(city);
        model.addAttribute("messages","Success");
        return "Edit";
    }

    @PostMapping("/city/delete/")
    public String deleteCity(Model model,@ModelAttribute City city){
        cityService.remove(city);
        model.addAttribute("message","Success");
        return "delete";
    }

    @GetMapping("/city/delete/{id}")
    public String getFromDeleteCity(Model model, @PathVariable Long id){
        City cityDelete=cityService.findById(id);
        model.addAttribute("cityDelete",cityDelete);
        return "delete";
    }

    @GetMapping("/city/create")
    public String getFromCreate(Model model){
         model.addAttribute("cityCreate",new City());
         return "create";
    }
    @PostMapping("/city/create")
    public String ceateCity(Model model,@ModelAttribute City city){
        cityService.save(city);
        model.addAttribute("message", "success");
        return "create";
    }


}
