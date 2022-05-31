package com.company;

import java.time.LocalDate;



public class Food extends PerishableProducts {

    public Food(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price, expirationDate);
    }

}
