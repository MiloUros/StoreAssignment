package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cashier cashier = new Cashier();

        List<Products> cart  = new ArrayList<>();

        Food apples = new Food("apples", "BrandA", 1.50, LocalDate.of(2021, 6, 14));
        Beverage milk = new Beverage("milk", "BrandM", 0.99, LocalDate.of(2022, 2, 2));
        Clothes tShirt = new Clothes("T-shirt", "BrandT", 15.99, "M", "violet");
        Appliance lapTop = new Appliance("laptop", "BrandL", 2345, "ModelL", "2021-03-03", 1.125);

        cashier.purchase(2.45, apples, cart );
        cashier.purchase(3, milk, cart );
        cashier.purchase(2, tShirt, cart );
        cashier.purchase(1, lapTop, cart );

        cashier.printReceipt(cart , LocalDateTime.of(2021, 6, 14, 12, 34, 56));

    }
}
