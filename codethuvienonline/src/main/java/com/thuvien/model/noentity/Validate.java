package com.thuvien.model.noentity;

import com.thuvien.model.Users;
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
        Users users=(Users)target;
        String fistName=users.getFistName();
        String lastName=users.getLastName();
        String username=users.getUserName();
        String email=users.getEmail();
        String password=users.getPassWord();
        String repass=users.getRePass();
        ValidationUtils.rejectIfEmpty(errors,"repass","repass.emtpy");
        ValidationUtils.rejectIfEmpty(errors,"username","username.empty");
        ValidationUtils.rejectIfEmpty(errors,"password","password.empty");
        ValidationUtils.rejectIfEmpty(errors,"fistname","fistname.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastname","lastname.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
//        if (phone.length()<10||phone.length()<11){
//            errors.rejectValue("phone","phone.length");
//        }
//        if (!phone.startsWith("0")){
//            errors.rejectValue("phone","phone.startsWith");
//        }
//        if (!phone.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("phone","phone.matcher");
//        }
        if (!repass.equals(users.getPassWord())){
            errors.rejectValue("repass","repass.equals");
        }
        if (username.length()<5||username.length()>45){
            errors.rejectValue("username","username.length");
        }
        if (password.length()<5||password.length()>45){
            errors.rejectValue("password","password.length");
        }
        if (fistName.length()<5||fistName.length()>45){
            errors.rejectValue("fistname","fistname.length");
        }
        if (lastName.length()<5||lastName.length()>45){
            errors.rejectValue("lastname","lastname.length");
        }
        if (!email.matches("^[a-zA-Z][\\\\w-]+@([\\\\w]+\\\\.[\\\\w]+|[\\\\w]+\\\\.[\\\\w]{2,}\\\\.[\\\\w]{2,})$")){
            errors.rejectValue("email","email.matches");
        }
    }
}
