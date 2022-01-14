package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appliance extends Products {

    //VARIABLES OF THE CLASS
    private final String model;

    //CONSTRUCTOR
    public Appliance(String name, String brand, double price, String model, String productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
    }

    //GETTER FOR THE VARIABLES
    public String getModel() {
        return model;
    }



    //OVERRIDDEN METHOD FOR PRINTING OBJECTS OF THIS CLASS
    @Override
    public void print(LocalDateTime dateTime) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(getName() + " " + getBrand() + " " + getModel());
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
        if ((dayOfTheWeek.equals("SATURDAY") || dayOfTheWeek.equals("SUNDAY")) && getPrice() > 999) {
            return 5;
        } else {
            return 0;
        }
    }

}
