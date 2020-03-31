package com.codegym.model;


public class User {

    private String userName;

    private String passWord;

    private String rePass;

    private String fistName;

    private String lastname;

    private String phone;

    private String email;

    public User() {

    }

    public User(String userName, String passWord, String rePass, String fistName, String lastname, String phone, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.rePass = rePass;
        this.fistName = fistName;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
