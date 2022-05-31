package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Cashier {

    DateTimeFormatter dateAndTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void printReceipt(List<Products> products, LocalDateTime dateAndTimeOfPurchase) {
        DecimalFormat formatDecimals = new DecimalFormat("0.00");
        formatDecimals.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("Date: " + dateAndTimeFormat.format(dateAndTimeOfPurchase) + "\n\n" + "---Products---" + "\n\n");

        printProducts(dateAndTimeOfPurchase, products);

        System.out.print("-----------------------------------------------------------------------------------" + "\n\n");

        System.out.println("SUBTOTAL: $" + formatDecimals.format(sumPrices(products)));
        System.out.println("DISCOUNT: $" + formatDecimals.format(sumDiscounts(dateAndTimeOfPurchase, products)) + "\n");
        System.out.println("TOTAL: $" + formatDecimals.format((sumPrices(products) - sumDiscounts(dateAndTimeOfPurchase, products))));


    }


    public void purchase(double numOfProducts, Products product, List<Products> products) {
        product.setNumOfProducts(numOfProducts);
        products.add(product);
    }

    public void printProducts(LocalDateTime dateAndTime, List<Products> products) {

        for (int i = 0; i < products.size(); i++) {
            products.get(i).print(dateAndTime);
            if (i == products.size() - 1) {
                System.out.println(" ");
            } else {
                System.out.println("\n");
            }
        }
    }

    public double sumPrices(List<Products> products) {

        double sumPrices = 0;
        for (Products product : products) {
            sumPrices += (product.getPrice() * product.getNumOfProducts());
        }
        return sumPrices;
    }

    public double sumDiscounts(LocalDateTime dateAndTime, List<Products> products) {
        double sumDiscounts = 0;
        for (Products product : products) {
            sumDiscounts += (product.getPrice() * product.getNumOfProducts()) * (product.discount(dateAndTime) / 100);
        }
        return sumDiscounts;
    }

}
