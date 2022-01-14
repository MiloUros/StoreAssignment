package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Cashier {

    DateTimeFormatter dateAndTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //METHOD FOR PRINTING THE RECEIPT
    public void printReceipt(List<Products> products, LocalDateTime dateAndTimeOfPurchase) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        // PRINTING HEADER
        System.out.println("Date: " + dateAndTimeFormat.format(dateAndTimeOfPurchase) + "\n\n" + "---Products---" + "\n\n");

        // PRINTING PRODUCTS
        printProducts(dateAndTimeOfPurchase, products);

        // PRINTING FOOTER
        System.out.print("-----------------------------------------------------------------------------------" + "\n\n");

        System.out.println("SUBTOTAL: $" + formatDecimals.format(sumOfPrices(products)));
        System.out.println("DISCOUNT: $" + formatDecimals.format(sumOfDiscounts(dateAndTimeOfPurchase, products)) + "\n");
        System.out.println("TOTAL: $" + formatDecimals.format((sumOfPrices(products) - sumOfDiscounts(dateAndTimeOfPurchase, products))));


    }


    // METHOD FOR PURCHASING PRODUCTS
    public void purchase(double numOfProducts, Products product, List<Products> products) {
        product.setNumOfProducts(numOfProducts);
        products.add(product);
    }

    // PRINTING JUST THE PRODUCTS
    public void printProducts(LocalDateTime dateAndTime, List<Products> products) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);


        for (int i = 0; i < products.size(); i++) {
            products.get(i).print(dateAndTime);
            if (i == products.size() - 1) {
                System.out.println(" ");
            } else {
                System.out.println("\n");
            }
        }
    }

    // SUMMING ALL THE PRICES
    public double sumOfPrices(List<Products> products) {

        double sumOfPrices = 0;
        for (Products product : products) {
            sumOfPrices += (product.getPrice() * product.getNumOfProducts());
        }
        return sumOfPrices;
    }

    //SUMMING ALL THE DISCOUNTS
    public double sumOfDiscounts(LocalDateTime dateAndTime, List<Products> products) {
        double sumOfDiscounts = 0;
        for (Products product : products) {
            if (product.discount(dateAndTime) == 50) {
                sumOfDiscounts += (product.getPrice() * product.getNumOfProducts()) * 0.5;
            } else if (product.discount(dateAndTime) == 10) {
                sumOfDiscounts += (product.getPrice() * product.getNumOfProducts()) * 0.1;
            } else if (product.discount(dateAndTime) == 5) {
                sumOfDiscounts += (product.getPrice() * product.getNumOfProducts()) * 0.05;
            }
        }
        return sumOfDiscounts;
    }

}
