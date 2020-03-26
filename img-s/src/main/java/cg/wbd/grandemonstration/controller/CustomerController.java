package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("customers/home");
        String time="2020-03-26";
        java.time.LocalDate date=java.time.LocalDate.now();
        String dateDay=String.valueOf(date);
        System.out.println(dateDay);
        List<Customer> customers = customerService.findByTime(dateDay);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/save")
    public String updateCustomer(@ModelAttribute Customer customer) {
        java.time.LocalDate date=java.time.LocalDate.now();
        String dateDay=String.valueOf(date);
        customer.setLocaltime(dateDay);
        System.out.println(dateDay);
        customerService.save(customer);
        return "redirect:/customers";
    }
}
