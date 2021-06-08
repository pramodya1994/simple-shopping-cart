package org.sample;

import org.sample.exceptions.InvalidCustomerNameException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
