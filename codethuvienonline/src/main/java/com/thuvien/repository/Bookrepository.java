package com.thuvien.repository;

import com.thuvien.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepository extends JpaRepository<Book,Long> {
    Iterable<Book> findAllByNameStartsWith(String name);
    Page<Book> findAllByNameStartsWith(String name, Pageable pageable);
}
