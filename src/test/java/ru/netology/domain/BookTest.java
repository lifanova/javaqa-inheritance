package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
//    book.
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
//      book.
        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Book();
        //TShirt shirt = (TShirt) product;
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        // Вопрос к аудитории: чей метод вызовется?
        product.toString();
    }

    @Test
    public void shouldUseSetMethod() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, null);
        book.setAuthor("Tolkien");
    }

    @Test
    public void shouldUseHashcode() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, null);
        book.hashCode();
    }

    @Test
    public void shouldCompareEqualsObjects() {
        Book first = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        Book second = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertEquals(first, second);
    }

    @Test
    public void shouldCompareNonEqualsObjects() {
        Book first = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        Book second = new Book(2, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertNotEquals(first, second);
    }

    @Test
    public void shouldCompareDifferentObjects() {
        Book first = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        Smartphone second = new Smartphone(1, "IPhone", 20000, "Apple");
        assertNotEquals(first, second);
    }

    @Test
    public void shouldEqualsWithNullObject() {
        Book first = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertNotEquals(first, null);
    }

    @Test
    public void shouldMatches() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        String name = book.getName();

        assertTrue(book.matches(name));
    }

    @Test
    public void shouldIncorrectMatches() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertFalse(book.matches("The Lord of the Rings"));
    }

    @Test
    public void shouldMatchesByAuthor() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertTrue(book.matches(book.getAuthor()));
    }

    @Test
    public void shouldIncorrectMatchesByAuthor() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertFalse(book.matches("Frei"));
    }

    @Test
    public void shouldMatchesWithNullValue() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertFalse(book.matches(null));
    }

    @Test
    public void shouldMatchesWithEmptyValue() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");

        assertFalse(book.matches(""));
    }
}
