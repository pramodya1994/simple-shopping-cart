package org.sample.exceptions;

/**
 * Throws {@code InvalidCustomerNameException} when invalid customer name given for a customer.
 */
public class InvalidCustomerNameException extends Exception {

    public InvalidCustomerNameException() {
    }

    public InvalidCustomerNameException(String message) {
        super(message);
    }
}
