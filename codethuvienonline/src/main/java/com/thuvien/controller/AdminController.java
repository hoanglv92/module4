package com.thuvien.controller;



import com.thuvien.model.*;
import com.thuvien.model.noentity.BookFrom;
import com.thuvien.model.noentity.BookResult;
import com.thuvien.model.noentity.Pagination;
import com.thuvien.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@PropertySource("classpath:global_config_app.properties")
public class AdminController {
    @Autowired
    Environment env;
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



    @GetMapping("/api/home")
    @ResponseBody()
    public BookResult getBookList(@RequestParam(defaultValue = "10") int size ,
                                  @RequestParam(defaultValue = "0") int page){
        Page<Book>books=this.bookservice.getAllBook("",size,page);
        BookResult bookResult = new BookResult();
        bookResult.setData(books.getContent());

        Pagination pagination=new Pagination();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(books.getTotalElements());

        bookResult.setPagination(pagination);
        return bookResult;
    }

    @ModelAttribute("urlAnh")
    public String getUrlAnh(){
        return env.getProperty("file_upload").toString();
    }

    @ModelAttribute("kindofbookselect")
    public Iterable<Kindofbook>kindofbooks(){
        return kindofbookservicer.findAll();
    }
    @ModelAttribute("roleSelect")
    public Iterable<Role>roles(){
        return roleservice.findAll();
    }
    Page<Users>getUsers(String startWiths,int page ){
        return userservice.getAllUsers(startWiths,this.size,page);
    }

    @GetMapping("/admin/listuser/{page}")
    public ModelAndView getListUser(@PathVariable("page" )int pageReQuest){
        pageReQuest-=1;
        ModelAndView modelAndView=new ModelAndView("admin/listuser");
        List<Users> usersList=(List<Users>) userservice.findAllUsers();
        modelAndView.addObject("usersLists",getUsers("",pageReQuest));
        modelAndView.addObject("soTrang",getSotrang());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/user/delete/{id}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Users deleteUser(@PathVariable Long id){
        Users users=userservice.findUserById(id);
        userservice.move(users);
        return users;
    }


    @GetMapping("/admin/user/edit/{id}")
    public ModelAndView getFromEditUser(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("admin/edituser");
        Users users=userservice.findUserById(id);
        modelAndView.addObject("users",users);
        return modelAndView;

    }
    @PostMapping("/admin/user/edit/")
    public ModelAndView updateUser(@ModelAttribute Users users){
        ModelAndView modelAndView= new ModelAndView("admin/edituser");
        userservice.save(users);
        modelAndView.addObject("message","Sua thanh cong");
        return modelAndView;
    }

//    public void setPagination(){
//        Pagination pagination=new Pagination();
//        pagination.setSize(10);
//        pagination.setPage(0);
//    }


    private final int size=10;

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

    Page<Book>getBook(String startWith ,int page){
        return bookservice.getAllBook(startWith,this.size,page);
    }
    @GetMapping("/admin/{page}")
    public ModelAndView getBooksList(@PathVariable("page") int pageReQuest ){
        pageReQuest-=1;
        ModelAndView modelAndView=new ModelAndView("admin/index");
        String startWith="";
        List<Book> bookList=(List<Book>) bookservice.findAll();
        double soSach=0;
        double soLuotMuon=0;
        for (Book book:bookList){
            if (book.getSoluong()!=null){
                soSach+=book.getSoluong();

            }
            if (book.getLuotmuon()!=null){
                soLuotMuon+=book.getLuotmuon();
            }
        }
        List<Loan>loanList=(List<Loan>)loanservice.findAll();
        double soMuon=0;
        double soQuaHan=0;
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        for (Loan loan:loanList){
            if (loan.getAmount()!=null){
                soMuon+=loan.getAmount();
                if (loan.getDatePay()!=null){
                    if (date.after(loan.getDatePay())){
                        soQuaHan+=1;
                    }
                }
            }
        }

        modelAndView.addObject("booklist",getBook(startWith,pageReQuest));
        modelAndView.addObject("soTrang",getSotrang());
        modelAndView.addObject("soSach",soSach);
        modelAndView.addObject("soLuotMuon",soLuotMuon);
        modelAndView.addObject("soMuon",soMuon);
        modelAndView.addObject("soQuaHan",soQuaHan);

        return modelAndView;
    }

    @RequestMapping(value = "/admin/{page}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Page<Book> getListAllbooks(@PathVariable("page") int pageRequest){
        String startWith="";
        pageRequest-=1;
        return getBook(startWith,pageRequest) ;
    }


    @GetMapping("/admin/addbook/{page}")
    public ModelAndView getFromAddBook(@PathVariable("page") int pageRequest){
        pageRequest-=1;
        ModelAndView modelAndView=new ModelAndView("admin/addbook");
        String startWith="";
        modelAndView.addObject("bookslist",getBook(startWith,pageRequest));
        modelAndView.addObject("soTrang",getSotrang());
        return modelAndView;
    }


    @GetMapping("/admin/addkindofbook")
    public ModelAndView getFromAddKindofbook(){
        ModelAndView modelAndView=new ModelAndView("admin/addkindofbook");
        modelAndView.addObject("kindofBook",new Kindofbook());
        return modelAndView;
    }

    @GetMapping("/admin/kinofbooklist")
    public ModelAndView  getFromListKindofbook(){
        ModelAndView modelAndView=new ModelAndView("admin/kinofbooklist");
        List<Kindofbook>kindofbookList=(List<Kindofbook>) kindofbookservicer.findAll();
        modelAndView.addObject("kindofbookList",kindofbookList);
        return modelAndView;
    }

    @GetMapping("/admin/kindofbooklist/edit/{id}")
    public ModelAndView  getFromEditKindofbook(@PathVariable Long id){
        ModelAndView modelAndView =new ModelAndView("admin/editkinofbook");
        Kindofbook loaisach=kindofbookservicer.findById(id);
        modelAndView.addObject("loaisach",loaisach);
        return modelAndView;
    }

    @GetMapping("/admin/book/edit/{id}")
    public ModelAndView getFromEditBook(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("admin/editbook");
        Book book=bookservice.findById(id);
        book.setImg("");
        BookFrom bookFrom=new BookFrom();
        bookFrom.setId(id);
        bookFrom.setTrangthai(book.getTrangthai());
        bookFrom.setKindofbook(book.getKindofbook());
        bookFrom.setName(book.getName());
        bookFrom.setMotangan(book.getMotangan());
        bookFrom.setMotachitiet(book.getMotachitiet());
        bookFrom.setTacgia(book.getTacgia());
        bookFrom.setSoluong(book.getSoluong());
        bookFrom.setTinhtrang(book.getTinhtrang());
        modelAndView.addObject("bookFromedit",bookFrom);
        return modelAndView;
    }

    @PostMapping("/admin/book/edit/")
    public ModelAndView updateBook(@ModelAttribute BookFrom bookFrom,BindingResult result){
        ModelAndView modelAndView= new ModelAndView("admin/editbook");
        BookFrom bookFrom1=bookFrom;
        if (bookFrom.getTrangthai()==null){
            bookFrom.setTrangthai("Có Sẵn");
        }


        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
            modelAndView.addObject("message",result.getAllErrors());
        }
        MultipartFile multipartFile = bookFrom.getImg();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(bookFrom.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Book bookObject = new Book(bookFrom.getId(),bookFrom.getTrangthai(),bookFrom.getName(),
                bookFrom.getMotangan(), bookFrom.getMotachitiet(),fileName, bookFrom.getTinhtrang(),
                bookFrom.getSoluong(),bookFrom.getTacgia(),bookFrom.getKindofbook());

        // luu vao db
        //productService.save(productObject);
        bookservice.save(bookObject);
        modelAndView.addObject("message","Sủa Thành Công");
            modelAndView.addObject("bookFromedit",bookFrom1);
        return modelAndView;

    }


    @RequestMapping(value = "/admin/kindofbooklist/delete/{id}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Kindofbook deleteKindofBook(@PathVariable Long id){
        Kindofbook kindofbook=kindofbookservicer.findById(id);
        kindofbookservicer.move(kindofbook);
        return kindofbook;
    }


    @RequestMapping(value = "/admin/book/delete/{id}",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book deletebook(@PathVariable Long id){
        Book book=bookservice.findById(id);
        bookservice.move(book);
        return book;
    }




    @PostMapping("/admin/kindofbooklist/edit/")
    public ModelAndView  saveKindofBook(@ModelAttribute Kindofbook kindofbook,BindingResult result){
        ModelAndView modelAndView =new ModelAndView("admin/editkinofbook");
        if (result.hasErrors()){
            modelAndView.addObject("message","co loi");
        }else {
                System.out.println(kindofbook.getId());
                kindofbookservicer.save(kindofbook);
                modelAndView.addObject("message", "sua thanh cong");
                Kindofbook loaisach = kindofbookservicer.findById(kindofbook.getId());
                modelAndView.addObject("loaisach", loaisach);

        }

        return modelAndView;
    }

    @PostMapping("/admin/addkindofbook")
    public ModelAndView saveKinofBook(@ModelAttribute Kindofbook kindofbook){
        ModelAndView modelAndView=new ModelAndView("admin/addkindofbook");
        System.out.println(kindofbook.getName());
        List<Kindofbook>kindofbookList=(List<Kindofbook>) kindofbookservicer.findAll();
        for (Kindofbook value:kindofbookList){
            if (kindofbook.getName().equals(value.getName())){
                modelAndView.addObject("message","Loai sach nay da co");
                modelAndView.addObject("kinofBook",new Kindofbook());
            }else {
                if (kindofbook.getName().equals("")){
                    modelAndView.addObject("message","Chưa lây được thông tin Tên");
                    modelAndView.addObject("kinofBook",new Kindofbook());
                }else {
                    kindofbookservicer.save(kindofbook);
                    modelAndView.addObject("message","Thêm Thành Công");
                    modelAndView.addObject("kindofBook",new Kindofbook());
                }
            }
        }

        return modelAndView;
    }

//    @RequestMapping(value = "/admin/addkindofbook",method = RequestMethod.POST,
//    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public Kindofbook cearateKinofBook(@RequestBody Kindofbook kindofbook,BindingResult result){
//        System.out.println(kindofbook.getName());
//        if (result.hasErrors()){
//            System.out.println(result.getAllErrors());
//            return null;
//        }
//        kindofbookservicer.save(kindofbook);
//        return kindofbook;
//    }
    @GetMapping("/admin/addnewbook")
    public ModelAndView getFromCreateBook(){
        ModelAndView modelAndView=new ModelAndView("admin/addnewbook");
        modelAndView.addObject("bookfrom",new BookFrom());
        return modelAndView;
    }


   @PostMapping("/admin/addnewbook")
    public ModelAndView createBook(@ModelAttribute BookFrom bookFrom , BindingResult result){
        ModelAndView modelAndView=new ModelAndView("admin/addnewbook");
        System.out.println(bookFrom.getName());
        System.out.println(bookFrom.getMotangan());
        System.out.println(bookFrom.getSoluong());
        System.out.println(bookFrom.getTacgia());
        System.out.println(bookFrom.getKindofbook());

        if (bookFrom.getTrangthai()==null){
            bookFrom.setTrangthai("Có Sẵn");
        }


        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
            modelAndView.addObject("message",result.getAllErrors());
        }
        MultipartFile multipartFile = bookFrom.getImg();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(bookFrom.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Book bookObject = new Book(bookFrom.getTrangthai(),bookFrom.getName(),
                bookFrom.getMotangan(), bookFrom.getMotachitiet(),fileName, bookFrom.getTinhtrang(),
                bookFrom.getSoluong(),bookFrom.getTacgia(),bookFrom.getKindofbook());

        // luu vao db
        //productService.save(productObject);
        bookservice.save(bookObject);
        modelAndView.addObject("message","Them thanh cong");
        modelAndView.addObject("bookfrom",new BookFrom());
        return modelAndView;
    }

    @GetMapping("/admin/user")
    public ModelAndView getFromUser(){
        ModelAndView modelAndView=new ModelAndView("admin/Usermanager");
        return modelAndView;
    }
}
