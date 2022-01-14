package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Clothes extends Products{

    //VARIABLES OF TEH CLASS
    private final String size;
    private final String color;

    //CONSTRUCTOR
    public Clothes(String name, String brand, double price, String size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    //GETTER FOR THE VARIABLES
    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    //OVERRIDDEN METHOD FOR PRINTING OBJECTS OF THIS CLASS
    @Override
    public void print(LocalDateTime dateTime) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(getName() + " " + getBrand() + " " + getSize() + " " + getColor());
        System.out.println((int)getNumOfProducts() + " x $" + getPrice() + " = $" +
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
        String dayOfTheWeek = String.valueOf(purchased.getDayOfWeek());
        if (dayOfTheWeek.equals("MONDAY") || dayOfTheWeek.equals("TUESDAY") || dayOfTheWeek.equals("WEDNESDAY") || dayOfTheWeek.equals("THURSDAY") || dayOfTheWeek.equals("FRIDAY")) {
            return 10;
        } else {
            return 0;
        }
    }
}
