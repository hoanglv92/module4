package com.codegym.controller;
import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceIml;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService=new ProductServiceIml();
    @GetMapping("/")
    public String getIndex(Model model){
        List<Product>productList=productService.listAll();
        model.addAttribute("product",productList);
        return "/index";
    }
    @GetMapping("/product/create")
    public String getCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int)(Math.random()*10000));
        productService.save(product);
        redirect.addFlashAttribute("success","them san pham thanh cong");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/product/update")
    public String update(RedirectAttributes redirect,Product product){
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("success","sua san pham thanh cong");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/product/delete")
    public String remove(RedirectAttributes redirect ,Product product){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success","xoa thanh cong");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public  String view(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
}
