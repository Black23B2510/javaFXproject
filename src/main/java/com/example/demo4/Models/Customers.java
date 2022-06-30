package com.example.demo4.Models;

public class Customers {
    public int cusID;
    public String cusName, email, address, password;

    public Customers(int cusID, String cusName, String email, String address, String password) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Customers(String cusName, String email, String address, String password) {
        this.cusName = cusName;
        this.email = email;
        this.address = address;
        this.password = password;
    }
}
