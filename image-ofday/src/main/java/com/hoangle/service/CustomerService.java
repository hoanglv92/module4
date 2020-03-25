package com.hoangle.service;

import com.hoangle.model.Customer;

import java.time.LocalTime;
import java.util.List;

public interface CustomerService {
    List<Customer>findAll();

    List<Customer>  findByTime(String localTime);

    Customer save(Customer customer);

    List<Customer> save(List<Customer> customers);

    boolean exists(Long id);

    List<Customer> findAll(List<Long> id);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
