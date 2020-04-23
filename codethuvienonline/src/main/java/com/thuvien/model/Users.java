package com.thuvien.model;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=5 ,max = 45)
    private String fistName;
    @NotEmpty
    @Size(min=5 ,max = 45)
    private String lastName;
    @NotEmpty
    @Size(min=5 ,max = 45)
    private String userName;
    @NotEmpty
    @Size(min=5 ,max = 45)
    private String passWord;
    @NotEmpty
    @Size(min=5 ,max = 45)
    private String rePass;
    @NotEmpty
    private String email;
    private String status;
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Users() {
    }

    public Users(Long id,String address, String fistName, String lastName, String userName, String passWord, String email, Role role) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.address=address;
        this.role = role;
    }



    public Users(String fistName, String rePass, String lastName, String userName, String passWord, String email) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.rePass=rePass;
    }

    public Users(String fistName,String rePass, String lastName, String userName, String passWord, String email, Role role) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
        this.rePass=rePass;
    }


    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
