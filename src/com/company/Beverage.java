package com.company;

import java.time.LocalDate;


public class Beverage extends PerishableProducts {

    public Beverage(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price, expirationDate);
    }
}
