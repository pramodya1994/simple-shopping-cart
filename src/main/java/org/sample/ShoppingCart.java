package org.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * {@code ShoppingCart} represents shopping cart of the super market.
 */
public class ShoppingCart {

    private final UUID id;
    // Products map used to keep products with the qty
    // Assumed qty is related with cart, rather than product
    private final Map<Product, Double> products = new HashMap<>();
    // Consider `totalAmount` as the product amount only
    private double totalAmount = 0;
    // Consider `totalVat` as total of each product `tax`
    private double totalVat = 0;
    // Default shipping cost is set to 150, and
    // assume shipping cost is applicable for the cart, but not individual items
    private double shippingCost = 150.0;

    public ShoppingCart() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ShoppingCart that = (ShoppingCart) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Add product to the shopping cart.
     *
     * @param product product to be added
     * @param qty     quantity of the product
     */
    public void addProduct(Product product, double qty) {
        this.products.put(product, qty);
    }

    /**
     * Remove product form the shopping cart.
     *
     * @param product product to be removed
     */
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    /**
     * Calculate the total amount of the shopping cast.
     *
     * @return total amount of the shopping cart
     */
    public double calculateAmount() {
        products.forEach((product, qty) -> {
            this.totalVat += qty * product.getTax();
            this.totalAmount += qty * product.getPrice();
        });
        return this.totalAmount + this.totalVat + this.shippingCost;
    }

    /**
     * Setter to change the shipping cost of the shopping cart.
     *
     * @param shippingCost shipping cost to be set
     */
    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Map<Product, Double> getProducts() {
        return products;
    }

    public double getShippingCost() {
        return shippingCost;
    }
}
