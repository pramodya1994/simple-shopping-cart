package org.sample;

import org.sample.exceptions.InvalidPriceException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * {@code ShoppingCartTest} tests {@code ShoppingCart} functionalities.
 */
public class ShoppingCartTest {

    private ShoppingCart cart;
    Product bread;
    Product cake;

    @BeforeClass
    public void setUp() throws InvalidPriceException {
        this.cart = new ShoppingCart();
        this.bread = new Product("Grocery", "White Bread", 12.25, 0.25);
        this.cake = new Product("Bakery", "Butter Cake", 16.25, 0.5);
    }

    @Test(description = "Test add product to empty cart")
    public void testAddProductToEmptyCart() throws InvalidPriceException {
        this.cart.addProduct(bread, 3.0);

        Assert.assertEquals(this.cart.getProducts().size(), 1);
        Map.Entry<Product, Double> addedProduct = this.cart.getProducts().entrySet().iterator().next();
        Assert.assertEquals(addedProduct.getKey().getName(), "White Bread");
        Assert.assertEquals(addedProduct.getKey().getPrice(), 12.25);
        Assert.assertEquals(addedProduct.getValue(), 3.0);
    }

    @Test(description = "Test add product to non empty cart", dependsOnMethods = "testAddProductToEmptyCart")
    public void testAddProductToNonEmptyCart() throws InvalidPriceException {
        this.cart.addProduct(cake, 2.5);
        Assert.assertEquals(this.cart.getProducts().size(), 2);
    }

    @Test(description = "Test calculate amounts", dependsOnMethods = "testAddProductToNonEmptyCart")
    public void testCalculateAmount() {
        double expectedAmount = (12.25 + 0.25) * 3.0 + (16.25 + 0.5) * 2.5 + this.cart.getShippingCost();
        Assert.assertEquals(this.cart.calculateAmount(), expectedAmount);
    }

    @Test(description = "Test remove product", dependsOnMethods = "testCalculateAmount")
    public void testRemoveProduct() {
        this.cart.removeProduct(this.cake);
        Assert.assertEquals(this.cart.getProducts().size(), 1);
        Map.Entry<Product, Double> addedProduct = this.cart.getProducts().entrySet().iterator().next();
        Assert.assertEquals(addedProduct.getKey().getName(), "White Bread");
    }
}
