package org.sample;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.sample.exceptions.InvalidCustomerNameException;
import org.sample.exceptions.InvalidPriceException;
import org.sample.models.Customer;
import org.sample.models.Product;
import org.sample.models.ShoppingCart;

/**
 * This is the main class of this application.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // Config logger
        BasicConfigurator.configure();

        try {
            // Create some products
            Product bread = new Product("Grocery", "White Bread", 12.25, 0.25);
            Product milk = new Product("Grocery", "Milk", 22.0, 0.5);
            Product cake = new Product("Bakery", "Butter Cake", 16.25, 0.5);

            // Create two customers
            Customer john = new Customer("John Doe");
            Customer jane = new Customer("Jane Doe");

            ShoppingCart johnsCart = john.obtainCart();
            johnsCart.addProduct(bread, 1);
            double johnsAmount = johnsCart.calculateAmount();
            logger.info(john.getName() + "'s cart amount: $" + johnsAmount);

            ShoppingCart janesCart = jane.obtainCart();
            janesCart.addProduct(milk, 2);
            janesCart.addProduct(cake, 4);
            double janesAmount = janesCart.calculateAmount();
            logger.info(jane.getName() + "'s cart amount: $" + janesAmount);
        } catch (InvalidCustomerNameException e) {
            logger.error("Customer creation error: " + e.getMessage());
        } catch (InvalidPriceException e) {
            logger.error("Product creation error: " + e.getMessage());
        }
    }
}
