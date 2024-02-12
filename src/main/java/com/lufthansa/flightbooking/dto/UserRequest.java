package com.lufthansa.flightbooking.dto;

import com.lufthansa.flightbooking.enums.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserRequest {
    private long id;
    private String name;
    private String address;
    private String emailId;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String contactNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
