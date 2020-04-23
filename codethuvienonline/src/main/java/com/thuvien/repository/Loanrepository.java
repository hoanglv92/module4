package com.thuvien.repository;

import com.thuvien.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Loanrepository extends JpaRepository<Loan,Long> {
    Page<Loan> findAll( Pageable pageable);
}
