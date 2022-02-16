package com.codegym;

import java.io.Serializable;

public class PhoneBook implements Serializable {
    private String name;
    private String sex;
    private String phone;
    private String group;
    private String adress;
    private String email;
    private String facebook;
    private String dateOfBirth;


    public PhoneBook() {
    }

    public PhoneBook(String name, String sex, String phone, String group, String adress, String email, String facebook, String dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.group = group;
        this.adress = adress;
        this.email = email;
        this.facebook = facebook;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sex + ", " + this.phone + ", " + this.group + ", " + this.adress + ", " + this.email + ", " + this.facebook + ", " + this.dateOfBirth;
    }
}

