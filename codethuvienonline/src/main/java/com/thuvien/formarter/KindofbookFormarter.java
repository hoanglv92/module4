package com.thuvien.formarter;

import com.thuvien.model.Kindofbook;
import com.thuvien.service.Kindofbookservicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class KindofbookFormarter implements Formatter<Kindofbook> {
    @Autowired
    private Kindofbookservicer kindofbookservicer;
    @Autowired
    public KindofbookFormarter(Kindofbookservicer kindofbookservicer){
        this.kindofbookservicer=kindofbookservicer;
    }
    @Override
    public Kindofbook parse(String text, Locale locale) throws ParseException {
        return kindofbookservicer.findById(Long.parseLong(text))    ;
    }

    @Override
    public String print(Kindofbook object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
