package com.company;

import java.time.LocalDateTime;

public abstract class Products {

    // COMMON VALUES FOR ALL THE CLASSES
    private final String name;
    private final String brand;
    private final double price;
    private double numOfProducts;


    // COMMON CONSTRUCTOR FOR ALL THE CLASSES
    public Products(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    //GETTER AND SETTER FOR VARIABLES
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

    // METHOD FOR DETERMINING EXACT AMOUNT OF DISCOUNT
    protected double discountCalculator(double numOfProducts, LocalDateTime dateAndTime) {

        if (discount(dateAndTime) == 50) {
            return (getPrice() * numOfProducts) * 0.5;
        } else if (discount(dateAndTime) == 10) {
            return (getPrice() * numOfProducts) * 0.1;
        } else if (discount(dateAndTime) == 5) {
            return (getPrice() * numOfProducts) * 0.05;
        } else {
            return 0;
        }
    }

    // PRINTING DISCOUNT PERCENTAGE
    protected String printDiscount(LocalDateTime dateAndTime) {
        if (discount(dateAndTime) == 50) {
            return "#discount 50% -$";
        } else if (discount(dateAndTime) == 10) {
            return "#discount 10% -$";
        } else if (discount(dateAndTime) == 5) {
            return "#discount 5% -$";
        } else {
            return null;
        }
    }

    // COMMON METHOD FOR ALL CLASSES FOR PRINTING PRODUCTS OF EACH CLASS
    public abstract void print(LocalDateTime dateTime);

    // DETERMINING PERCENTAGE OF DISCOUNT
    public abstract int discount(LocalDateTime dateOfPurchase);
}
