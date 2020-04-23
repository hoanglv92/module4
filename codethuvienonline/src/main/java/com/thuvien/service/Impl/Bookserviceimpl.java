package com.thuvien.service.Impl;

import com.thuvien.model.Book;
import com.thuvien.repository.Bookrepository;
import com.thuvien.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class Bookserviceimpl implements Bookservice {
    @Autowired
    private Bookrepository bookrepository;


    @Override
    public Page<Book> getAllBook(String startWithText, int size, int page) {
        Pageable pageable= new PageRequest(page,size, Sort.Direction.DESC,"name");
        if (startWithText.isEmpty()){
            return this.bookrepository.findAll(pageable);
        }else {
            return this.bookrepository.findAllByNameStartsWith(startWithText,pageable);
        }
    }

    @Override
    public Iterable<Book> findAll() {
        Iterable<Book>findAll=bookrepository.findAll();
        return findAll;
    }

    @Override
    public Book findById(Long id) {
        Book book=bookrepository.findOne(id);
        return book;
    }

    @Override
    public Book save(Book book) {
        bookrepository.save(book);
        return book;
    }

    @Override
    public Book move(Book book) {
        bookrepository.delete(book);
        return book;
    }
}
