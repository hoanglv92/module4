package com.thuvien.formarter;

import com.thuvien.model.Role;
import com.thuvien.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class RoleFormarter implements Formatter<Role> {
    @Autowired
    Roleservice roleservice;

    @Autowired
    public RoleFormarter ( Roleservice roleservice){
        this.roleservice=roleservice;
    }
    @Override
    public Role parse(String text, Locale locale) throws ParseException {
        return roleservice.findRoleById(Long.parseLong(text));
    }

    @Override
    public String print(Role object, Locale locale) {
        return "[" + object.getId() + ", " +object.getRole() + "]";
    }
}
