package com.thuvien.service.Impl;

import com.thuvien.model.Kindofbook;
import com.thuvien.repository.Kindofbookrepository;
import com.thuvien.service.Kindofbookservicer;
import org.springframework.beans.factory.annotation.Autowired;

public class Kindofbookserviceimpl implements Kindofbookservicer {
    @Autowired
    private Kindofbookrepository kindofbookrepository;
    @Override
    public Iterable<Kindofbook> findAll() {
        Iterable<Kindofbook>findAll=kindofbookrepository.findAll();
        return findAll;
    }

    @Override
    public Kindofbook findById(Long id) {
        Kindofbook kindofbook=kindofbookrepository.findOne(id);
        return kindofbook;
    }

    @Override
    public Kindofbook save(Kindofbook kindofbook) {
        kindofbookrepository.save(kindofbook);
        return kindofbook;
    }

    @Override
    public Kindofbook move(Kindofbook kindofbook) {
        kindofbookrepository.delete(kindofbook);
        return kindofbook;
    }
}
