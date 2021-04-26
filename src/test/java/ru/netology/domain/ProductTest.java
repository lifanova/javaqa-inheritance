package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        assertEquals(first, second);
    }

    @Test
    public void shouldUseSetMethod() {
        Product product = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        product.setId(2);
        product.setName("");
        product.setPrice(12);
        product.getPrice();
    }

    @Test
    public void shouldUseToString() {
        Product product = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        product.toString();
    }

    @Test
    public void shouldUseHashcode() {
        Product product = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        product.hashCode();
    }

    @Test
    public void shouldCompareTheSame(){
        Product product = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        assertEquals(product, product);
    }

    @Test
    public void shouldCompareObjects() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        Product second = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);

        assertEquals(first, second);
    }

    @Test
    public void shouldCompareObjectWithDifferentId() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        Product second = new Product(2, "The Lord of the Rings: The Fellowship of the Ring", 200);

        assertNotEquals(first, second);
    }

    @Test
    public void shouldCompareObjectWithDifferentPrices() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        Product second = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 300);

        assertNotEquals(first, second);
    }

    @Test
    public void shouldCompareObjectWithDifferentNames() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        Product second = new Product(1, "The Lord of the Rings: The Two Towers", 200);

        assertNotEquals(first, second);
    }

    @Test
    public void shouldCompareObjectWithAllDifferentFields() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        Product second = new Product(2, "The Lord of the Rings: The Two Towers", 300);

        assertNotEquals(first, second);
    }


    @Test
    public void shouldCompareDifferentObjects() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);
        Smartphone second = new Smartphone(1, "IPhone", 20000, "Apple");
        assertNotEquals(first, second);
    }

    @Test
    public void shouldEqualsWithNullObject() {
        Product first = new Product(1, "The Lord of the Rings: The Fellowship of the Ring", 200);

        assertNotEquals(first, null);
    }
}
