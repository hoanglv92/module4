package com.codegym.service.Impl;

import com.codegym.model.Country;
import com.codegym.repository.CountryRepository;
import com.codegym.service.Countryservice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Countryserviceimpl implements Countryservice {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        List<Country>list=(List<Country>)countryRepository.findAll();
        return list;
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.delete(id);
    }
}
