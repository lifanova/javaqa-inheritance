package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository;


    @BeforeEach
    public void PrepareData() {
        repository = new ProductRepository();
    }

    @Test
    public void shouldSaveOneItem() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        repository.save(book);

        Product[] expected = new Product[]{book};

        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        repository.save(book);

        assertEquals(book, repository.findById(book.getId()));
    }

    @Test
    public void shouldFindByNonExistingId() {
        Book book = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        repository.save(book);

        assertEquals(null, repository.findById(2));
    }

    @Test
    public void shouldRemoveById() {
        Book first = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        Book second = new Book(2, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        repository.save(first);
        repository.save(second);

        repository.removeById(second.getId());

        assertEquals(null, repository.findById(second.getId()));
    }
}
