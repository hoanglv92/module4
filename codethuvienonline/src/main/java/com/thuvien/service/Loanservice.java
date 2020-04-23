package com.thuvien.service;

import com.thuvien.model.Loan;

public interface Loanservice {
    Iterable<Loan> findAll();
    Loan findById(Long id);
    Loan save(Loan loan);
    Loan move(Loan loan);
}
