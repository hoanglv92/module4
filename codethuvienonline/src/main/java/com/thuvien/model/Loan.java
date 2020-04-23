package com.thuvien.model;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "loan")
    private List<Book>bookList;

    private Long amount;
    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;
    private java.sql.Date dateBorrow;
    private java.sql.Date datePay;

    private String ghichu;

    public Loan() {

    }


    public Loan(Long id, List<Book> bookList, Users users, Date dateBorrow, Date datePay, String ghichu) {
        this.id = id;
        this.bookList = bookList;
        this.users = users;
        this.dateBorrow = dateBorrow;
        this.datePay = datePay;
        this.ghichu = ghichu;
    }

    public Loan(List<Book> bookList, Long amount, Users users, Date dateBorrow, Date datePay, String ghichu) {
        this.bookList = bookList;
        this.users = users;
        this.dateBorrow = dateBorrow;
        this.datePay = datePay;
        this.ghichu = ghichu;
        this.amount =amount;
    }

    public Loan(List<Book> bookList, Users users, Date dateBorrow, Date datePay) {
        this.bookList = bookList;
        this.users = users;
        this.dateBorrow = dateBorrow;
        this.datePay = datePay;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
