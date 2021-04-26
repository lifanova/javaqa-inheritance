package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Test
    public void shouldMatchesByName() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 20000, "Apple");
        String name = smartphone.getName();

        assertTrue(smartphone.matches(name));
    }

    @Test
    public void shouldIncorrectMatchesByName() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 200, "Apple");

        assertFalse(smartphone.matches("Nokia"));
    }

    @Test
    public void shouldMatchesByManufacturer() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 20000, "Apple");

        assertTrue(smartphone.matches(smartphone.getManufacturer()));
    }

    @Test
    public void shouldIncorrectMatchesByManufacturer() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 200, "Apple");

        assertFalse(smartphone.matches("Nokia"));
    }

    @Test
    public void shouldMatchesWithNullValue() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 200, "Apple");

        assertFalse(smartphone.matches(null));
    }

    @Test
    public void shouldMatchesWithEmptyValue() {
        Smartphone smartphone = new Smartphone(1, "IPhone", 200, "Apple");

        assertFalse(smartphone.matches(""));
    }
}
