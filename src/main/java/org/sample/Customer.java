package org.sample;

import org.sample.exceptions.InvalidCustomerNameException;

public class Customer {

    // Adding customer details fields.
    // Only adding name field for now, can add more.
    private String name;
    private ShoppingCart cart;

    public Customer(String name) throws InvalidCustomerNameException {
        if (name.isEmpty()) {
            throw new InvalidCustomerNameException("Customer name should not be empty");
        }
        this.name = name;
    }

    /**
     * Obtain shopping cart for the customer.
     *
     * @return obtained shopping cart
     */
    public ShoppingCart obtainCart() {
        if (cart == null) {
            this.cart = new ShoppingCart();
        }
        return this.cart;
    }

    public void setName(String name) throws InvalidCustomerNameException {
        if (name.isEmpty()) {
            throw new InvalidCustomerNameException("Customer name should not be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
