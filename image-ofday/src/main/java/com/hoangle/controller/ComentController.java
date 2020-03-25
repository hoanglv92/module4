package com.hoangle.controller;

import com.hoangle.model.Customer;
import com.hoangle.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ComentController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/home")
    public String gethome(Model model){
        java.time.LocalDate date=java.time.LocalDate.now();
        String dateDay= String.valueOf(date);
        List<Customer>customers=customerService.findByTime(dateDay);
        if (customers.size()>0) {
            model.addAttribute("customers", customers);
        }
        model.addAttribute("customer",new Customer());
        return "home";
    }
    @PostMapping("/home/save")
    public String save(RedirectAttributes redirect, Customer customer){
        java.time.LocalDate date=java.time.LocalDate.now();
        String date1=((String.valueOf(date))) ;
        customer.setLocalTime(date1);
        customerService.save(customer);
        redirect.addFlashAttribute("success","them binh luan thanh cong");
        return "redirect:/home";
    }
    @PostMapping("/home/like")
    public String update(RedirectAttributes redirect, Customer customer){

        return "redirect:/home";
    }
}
