package com.hoang.service;

import com.hoang.model.Customer;
import com.hoang.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
