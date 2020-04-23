package com.thuvien.service;

import com.thuvien.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Bookservice {
    Page<Book> getAllBook(String startWithText, int size, int page);
    Iterable<Book>findAll();
    Book findById(Long id);
    Book save(Book book);
    Book move(Book book);
}
