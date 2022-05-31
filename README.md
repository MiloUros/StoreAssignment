# StoreAssignment

Store
Assignment

In a store you can buy different products - food, beverages, clothes, appliances.

Each product has a name, brand and price. 

The perishable products (food and beverages) have expiration dates as well. 

For the clothes a size (standard from XS, S, M, L, XL) and color is stored, and for appliances - model, production date and weight (in kg).

If perishable products are about to expire a discount is added - 10% if the expiration date is within 5 days of the purchase date and 50% if the product expires at the date of purchase.

There is a 10% discount on all clothes bought during the working days, and 5% discount on all appliances that cost above $999 and are purchased during the weekend.


Create a class Cashier that has a method to print a receipt. The method accepts a cart (collection of products) and the date and time of purchase. It should print all purchased products with their price, quantity, the total sum and the total discount in the format:


Date: <date and time of purchase>
---Products---


<name> <brand>
<quantity> x <price per product> = <total price without discount>
#discount <discount %> <discount sum> (if applicable)

-----------------------------------------------------------------------------------

SUBTOTAL: <total sum for all products>
DISCOUNT: - <sum of all discounts>

TOTAL: <sum to pay>


Your task is to model the whole structure of the store - products, purchase, cart, cashier - following the object-oriented principles. You can use the examples below to test your application. No user input needed.
