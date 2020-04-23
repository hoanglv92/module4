package com.codegym.Formatter;

import com.codegym.model.Country;
import com.codegym.service.Countryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFomatter implements Formatter<Country> {
    @Autowired
    Countryservice countryservice;
    @Autowired
    public CountryFomatter(Countryservice countryservice) {
        this.countryservice = countryservice;
    }
    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryservice.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
