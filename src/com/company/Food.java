package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Food extends Products {

    //VARIABLES OF TEH CLASS
    protected final LocalDate expirationDate;

    //CONSTRUCTOR
    public Food(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    //OVERRIDDEN METHOD FOR PRINTING OBJECTS OF THIS CLASS
    @Override
    public void print(LocalDateTime dateTime) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(getName() + " - " + getBrand());
        System.out.println(getNumOfProducts() + " x $" + getPrice() + " = $" +
                formatDecimals.format(getNumOfProducts() * getPrice()));

        if (discount(dateTime) != 0) {
            System.out.println(printDiscount(dateTime) +
                    formatDecimals.format(discountCalculator(getNumOfProducts(), dateTime)));

        }
    }

    //OVERRIDDEN METHOD FOR CALCULATING DISCOUNT FOR OBJETS OF THIS CLASS
    @Override
    public int discount(LocalDateTime dateOfPurchase) {
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
