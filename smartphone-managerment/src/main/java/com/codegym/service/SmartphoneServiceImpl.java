package com.codegym.service;

import com.codegym.model.Smartphone;
import com.codegym.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        Smartphone smartphone= smartphoneRepository.findOne(id);
        if (smartphone==null){
            return null;
        }else {
            return smartphone;
        }
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone=findById(id);
         smartphoneRepository.delete(id);
         return smartphone;
    }
}
