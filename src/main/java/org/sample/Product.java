package org.sample;

import org.sample.exceptions.InvalidPriceException;

/**
 * {@code Product} represents any product in the super market.
 */
public class Product {

    private String title;
    private String name;
    private double price;
    private double tax;

    public Product(String title, String name, double price, double tax) throws InvalidPriceException {
        this.title = title;
        this.name = name;
        if (price > 0) {
            this.price = price;
        } else {
            throw new InvalidPriceException("Invalid product price: " + price);
        }
        // There can be products with zero tax
        if (tax >= 0) {
            this.tax = tax;
        } else {
            throw new InvalidPriceException("Invalid tax amount: " + tax);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if (price > 0) {
            this.price = price;
        } else {
            throw new InvalidPriceException("Invalid product price: " + price);
        }
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) throws InvalidPriceException {
        // There can be products with zero tax
        if (tax >= 0) {
            this.tax = tax;
        } else {
            throw new InvalidPriceException("Invalid tax amount: " + tax);
        }
    }
}
