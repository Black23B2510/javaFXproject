package com.example.demo4.Models;

public class products {
    public int id;
    public int quantity;
    public Float price;
    public String name, NSX, image;

    public products(int id, String name, String NSX, String image, Float price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.NSX = NSX;
        this.image = image;
    }

    public products( String name, String NSX, String image,Float price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.NSX = NSX;
        this.image = image;
    }
}
