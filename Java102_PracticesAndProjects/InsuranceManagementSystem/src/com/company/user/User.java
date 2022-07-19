package com.company.user;

import com.company.address.Address;
import com.company.insurance.Insurance;

import java.util.ArrayList;
import java.util.Date;

public class User{

    private String name;
    private String surname;
    private String email;
    private String password;
    private String profession;
    private int age;
    private ArrayList<Address> addressArrayList = new ArrayList<>();
    private ArrayList<Insurance> insuranceArrayList = new ArrayList<>();
    private Date lastEntranceDate;

    public User(String name, String surname, String email,  String password, String profession, int age){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.profession = profession;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getLastEntranceDate() {
        return lastEntranceDate;
    }

    public void setLastEntranceDate(Date lastEntranceDate) {
        this.lastEntranceDate = lastEntranceDate;
    }

    public ArrayList<Address> getAddressArrayList() {
        return addressArrayList;
    }

    public void setAddressArrayList(Address addressArrayList) {
        this.addressArrayList.add(addressArrayList);
    }

    public ArrayList<Insurance> getInsuranceArrayList() {
        return insuranceArrayList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
