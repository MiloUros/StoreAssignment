package com.company;

import java.time.LocalDateTime;

public abstract class Products {

    private final String name;
    private final String brand;
    private final double price;
    private double numOfProducts;


    public Products(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public double getPrice() {
        return price;
    }
    public double getNumOfProducts() {
        return numOfProducts;
    }
    public void setNumOfProducts(double numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    public abstract void print(LocalDateTime dateTime);

    public abstract float discount(LocalDateTime dateOfPurchase);
}
