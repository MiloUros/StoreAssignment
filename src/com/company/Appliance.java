package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appliance extends Products {

    private final String model;

    public Appliance(String name, String brand, double price, String model, String productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }



    @Override
    public void print(LocalDateTime dateTime) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(getName() + " " + getBrand() + " " + getModel());
        System.out.println((int)getNumOfProducts() + " x $" + getPrice() + " = $" +
                formatDecimals.format(getNumOfProducts() * getPrice()));

        if (discount(dateTime) != 0) {
            System.out.println("#discount " + (int) discount(dateTime) +  "% -$" +
                    formatDecimals.format((getPrice() * getNumOfProducts()) * (discount(dateTime) / 100)));

        }
    }


    @Override
    public float discount(LocalDateTime dateOfPurchase) {
        LocalDate purchased = dateOfPurchase.toLocalDate();
        String dayOfTheWeek = String.valueOf(purchased.getDayOfWeek());
        if ((dayOfTheWeek.equals("SATURDAY") || dayOfTheWeek.equals("SUNDAY")) && getPrice() > 999) {
            return 5;
        } else {
            return 0;
        }
    }

}
