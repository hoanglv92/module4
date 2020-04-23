package com.thuvien.service;

import com.thuvien.model.Kindofbook;

public interface Kindofbookservicer {
    Iterable<Kindofbook> findAll();
    Kindofbook findById(Long id);
    Kindofbook save(Kindofbook kindofbook);
    Kindofbook move(Kindofbook kindofbook);
}
