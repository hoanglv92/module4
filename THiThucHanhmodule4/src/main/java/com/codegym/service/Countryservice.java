package com.codegym.service;


import com.codegym.model.Country;

import java.util.List;

public interface Countryservice {
    List<Country> findAll();
    Country findById(Long id);
    void save(Country country);
    void remove(Long id);
}
