package com.codegym.service.Impl;

import com.codegym.model.City;
import com.codegym.repository.CityRepository;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Cityserviceimpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> findAll() {
        List<City> cityList=(List<City>)cityRepository.findAll();
        return cityList;
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(City city) {
        cityRepository.delete(city);
    }
}
