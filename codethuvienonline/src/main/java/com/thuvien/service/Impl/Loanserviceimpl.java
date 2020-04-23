package com.thuvien.service.Impl;

import com.thuvien.model.Loan;
import com.thuvien.repository.Loanrepository;
import com.thuvien.service.Loanservice;
import org.springframework.beans.factory.annotation.Autowired;

public class Loanserviceimpl implements Loanservice {
    @Autowired
    private Loanrepository loanrepository;
    @Override
    public Iterable<Loan> findAll() {
        Iterable<Loan> loans=loanrepository.findAll();
        return loans;
    }

    @Override
    public Loan findById(Long id) {
        Loan loan=loanrepository.findOne(id);
        return loan;
    }

    @Override
    public Loan save(Loan loan) {
        loanrepository.save(loan);
        return loan;
    }

    @Override
    public Loan move(Loan loan) {
        loanrepository.delete(loan);
        return loan;
    }
}
