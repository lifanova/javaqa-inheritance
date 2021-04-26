package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SmartphoneTest {

    @Test
    public void shouldUseSetMethod() {
        Smartphone smartphone = new Smartphone();
        smartphone.setId(2);
        smartphone.setName("");
        smartphone.setPrice(12);
        smartphone.getPrice();
        smartphone.setManufacturer("");
        smartphone.getManufacturer();
    }

    @Test
    public void shouldUseHashcode() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 20000, "Apple");
        smartphone.hashCode();
    }

    @Test
    public void shouldCompareTheSame(){
        Smartphone smartphone = new Smartphone(1, "IPhone", 20000, "Apple");
        assertEquals(smartphone, smartphone);
    }

    @Test
    public void shouldCompareNull(){
        Smartphone smartphone = new Smartphone(1, "IPhone", 20000, "Apple");
        assertNotEquals(smartphone, null);
    }

    @Test
    public void shouldCompareEqualsObjects() {
        Smartphone first = new Smartphone(1, "IPhone", 20000, "Apple");
        Smartphone second = new Smartphone(1, "IPhone", 20000, "Apple");

        assertEquals(first, second);
    }

    @Test
    public void shouldCompareNonEqualsObjects() {
        Smartphone first = new Smartphone(1, "IPhone", 20000, "Apple");
        Smartphone second = new Smartphone(2, "IPhone", 70000, "Apple");

        assertNotEquals(first, second);
    }

    @Test
    public void shouldCompareDifferentObjects() {
        Smartphone first = new Smartphone(1, "IPhone", 20000, "Apple");
        Book second = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertNotEquals(first, second);
    }

    @Test
    public void shouldEqualsWithNullObject() {
        Smartphone first = new Smartphone(1, "IPhone", 20000, "Apple");

        assertNotEquals(first, null);
    }
}
