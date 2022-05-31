package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PerishableProducts extends Products{

    protected final LocalDate expirationDate;
    public PerishableProducts(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public void print(LocalDateTime dateTime) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(getName() + " - " + getBrand() + "\n");
        System.out.println(getNumOfProducts() + " x $" + getPrice() + " = $" +
                formatDecimals.format(getNumOfProducts() * getPrice()) + "\n");

        if (discount(dateTime) != 0) {
            System.out.println("#discount " + (int) discount(dateTime) +  "% -$" +
                    formatDecimals.format((getPrice() * getNumOfProducts()) * (discount(dateTime) / 100)));

        }
    }

    @Override
    public float discount(LocalDateTime dateOfPurchase) {
        LocalDate purchased = dateOfPurchase.toLocalDate();
        long days = ChronoUnit.DAYS.between(this.expirationDate, dateOfPurchase);
        if (this.expirationDate.compareTo(purchased) == 0) {
            return 50;
        } else if (days > 0 && days < 6) {
            return 10;
        } else {
            return 0;
        }
    }
}
