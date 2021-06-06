package org.sample.exceptions;

/**
 * Throws {@code InvalidPriceException} when invalid price given for a product.
 */
public class InvalidPriceException extends Exception {

    public InvalidPriceException() {
    }

    public InvalidPriceException(String message) {
        super(message);
    }
}
