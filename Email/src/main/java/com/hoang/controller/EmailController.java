package com.hoang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @GetMapping("/home")
    public String getIndex() {
        return "indexen";
    }

    @PostMapping("/home")
    public String getHome(@RequestParam String laguege, int size, String textaria, Model model) {
        if (laguege.equals("english") && size == 25) {
            model.addAttribute(textaria);
            return "indexen";
        } else if (laguege.equals("english") && size == 50) {
            model.addAttribute(textaria);
            return "indexensize50";
        } else if (laguege.equals("english") && size == 100) {
            model.addAttribute(textaria);
            return "indexsize100";
        } else if (laguege.equals("vietnam") && size == 25) {
            model.addAttribute(textaria);
            return "indextv";
        } else if (laguege.equals("vietnam") && size == 50) {
            model.addAttribute(textaria);
            return "indexvn50";
        } else if (laguege.equals("vietnam") && size == 100) {
            model.addAttribute(textaria);
            return "indexvn100";
        }else {
            return "indexen";
        }
    }

}
