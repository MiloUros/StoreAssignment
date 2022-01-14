package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Beverage extends Food {

    //CONSTRUCTOR
    public Beverage(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price, expirationDate);
    }

    //OVERRIDDEN METHOD FOR PRINTING OBJECTS OF THIS CLASS
    @Override
    public void print(LocalDateTime dateTime) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(getName() + " " + getBrand());
        System.out.println((int)getNumOfProducts() + " x $" + getPrice() + " = $" +
                formatDecimals.format(getNumOfProducts() * getPrice()));

        if (discount(dateTime) != 0) {
            System.out.println(printDiscount(dateTime) +
                    formatDecimals.format(discountCalculator(getNumOfProducts(), dateTime)));

        }
    }
}
