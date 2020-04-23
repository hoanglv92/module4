package com.thuvien.controller;


import com.thuvien.model.Book;
import com.thuvien.model.Role;
import com.thuvien.model.Users;
import com.thuvien.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private Bookservice bookservice;
    @Autowired
    private Roleservice roleservice;
    @Autowired
    private Loanservice loanservice;
    @Autowired
    private Kindofbookservicer kindofbookservicer;
    @Autowired
    private Userservice userservice;

    private final int size=10;

    private String getPrincipal() {
        String role = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            role = String.valueOf(((UserDetails) principal).getUsername());
        }
        return role;
    }

    public List<Integer> getSotrang() {
        List<Book> books = (List<Book>) bookservice.findAll();
        int trang=1;
        if (books.size() > 10) {
            trang = (books.size() / 10) + 1;
        }
        List<Integer>sotrang = new ArrayList<>();
        for (int i=1;i<=trang;i++){
            sotrang.add(i);
        }
        return sotrang;
    }

    Page<Book> getBook(String startWith,int page){
        return bookservice.getAllBook(startWith,this.size,page);
    }

    @ModelAttribute("userName")
    public String getUserName(){
        return getPrincipal();
    }

    @GetMapping("/home/{page}")
    public ModelAndView getTrangChu(@PathVariable("page") int pageRequest) {
        pageRequest-=1;
        ModelAndView modelAndView = new ModelAndView("client/index");
        String startWith="";

        modelAndView.addObject("listBooks",getBook(startWith,pageRequest));
        modelAndView.addObject("soTrang",getSotrang());
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getFromRegister() {
        ModelAndView modelAndView = new ModelAndView("client/register");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute Users users, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("client/register");
        List<Users> list = (List<Users>) userservice.findAllUsers();
        for (Users value : list) {
            if (value.getUserName().equals(users.getUserName()) ||
                    value.getEmail().equals(users.getEmail())) {
                modelAndView.addObject("messager", "Tài Khoản Hoặc Email Đã Tồn Tại");
            }else if (!users.getPassWord().equals(users.getRePass())){
                modelAndView.addObject("messager","Nhập Lại Mật Khẩu Không Đúng");
            } else {
                Role role = new Role(1L, "ROLE_USER");
                users.setRole(role);
                if (bindingResult.hasErrors()) {
                    modelAndView.addObject("messager", "Bạn Hãy Chắc Chắn Nhập đúng dữ liệu,hiện không thể tạo tài khoản");
                } else {
                    userservice.save(users);
                    modelAndView.addObject("messager", "Tao Tai Khoan Thanh Cong");
                }
            }
        }
        return modelAndView;
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public Users createUsers(@RequestBody Users users, BindingResult bindingResult) {
//        System.out.println(users.getUserName());
//        System.out.println(users.getPassWord());
//        System.out.println(users.getEmail());
//        System.out.println(users.getRePass());
//        Role role = new Role(1L, "ROLE_USER");
//        users.setRole(role);
//        if (!bindingResult.hasErrors()) {
//            userservice.save(users);
//            return users;
//        } else {
//            return null;
//        }
//    }

    @GetMapping("/login")
    public ModelAndView getFromLogin() {
        ModelAndView modelAndView = new ModelAndView("client/login");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }


    @GetMapping("/home/bookdetail/{id}")
    public ModelAndView getFromBookDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("client/bookdetails");
        Book bookShow=bookservice.findById(id);
        modelAndView.addObject("bookShow",bookShow);
        return modelAndView;
    }
    @PostMapping("/home/cartbook/{id}")
    public ModelAndView saveCart(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("client/shop");
        List<Book>bookListCart=new ArrayList<>();
        Book bookcart=bookservice.findById(id);
        bookListCart.add(bookcart);
        modelAndView.addObject("bookListCart",bookListCart);
        return modelAndView;
    }

}
