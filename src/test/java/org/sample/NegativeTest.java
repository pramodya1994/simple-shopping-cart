package org.sample;

import org.sample.exceptions.InvalidCustomerNameException;
import org.sample.exceptions.InvalidPriceException;
import org.sample.models.Customer;
import org.sample.models.Product;
import org.testng.annotations.Test;

/**
 * {@code NegativeTest} tests negative cases of Customer & Product creation.
 */
public class NegativeTest {

    @Test(description = "Test create customer with empty name",
            expectedExceptions = InvalidCustomerNameException.class,
            expectedExceptionsMessageRegExp = "Customer name should not be empty")
    public void testCreateCustomerWithEmptyName() throws InvalidCustomerNameException {
        new Customer("");
    }

    @Test(description = "Test create product with invalid price",
            expectedExceptions = InvalidPriceException.class,
            expectedExceptionsMessageRegExp = "Invalid product price: -1.25")
    public void testCreateProductWithInvalidPrice() throws InvalidPriceException {
        new Product("Grocery", "Floor", -1.25, 0.5);
    }
}
