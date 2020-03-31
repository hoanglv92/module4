package com.codegym.validation;

import com.codegym.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class Validate implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user =(User)target;
        String phone=user.getPhone();
        String repass=user.getRePass();
        String username=user.getUserName();
        String password=user.getPassWord();
        String fistname=user.getFistName();
        String lastname=user.getLastname();
        String email=user.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"repass","repass.emtpy");
        ValidationUtils.rejectIfEmpty(errors,"phone","phone.empty");
        ValidationUtils.rejectIfEmpty(errors,"username","username.empty");
        ValidationUtils.rejectIfEmpty(errors,"password","password.empty");
        ValidationUtils.rejectIfEmpty(errors,"fistname","fistname.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastname","lastname.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if (phone.length()<10||phone.length()<11){
            errors.rejectValue("phone","phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone","phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone","phone.matcher");
        }
        if (!repass.equals(user.getPassWord())){
            errors.rejectValue("repass","repass.equals");
        }
        if (username.length()<5||username.length()>45){
            errors.rejectValue("username","username.length");
        }
        if (password.length()<5||password.length()>45){
            errors.rejectValue("password","password.length");
        }
        if (fistname.length()<5||fistname.length()>45){
            errors.rejectValue("fistname","fistname.length");
        }
        if (lastname.length()<5||lastname.length()>45){
            errors.rejectValue("lastname","lastname.length");
        }
        if (!email.matches("^[a-zA-Z][\\\\w-]+@([\\\\w]+\\\\.[\\\\w]+|[\\\\w]+\\\\.[\\\\w]{2,}\\\\.[\\\\w]{2,})$")){
            errors.rejectValue("email","email.matches");
        }
    }
}
