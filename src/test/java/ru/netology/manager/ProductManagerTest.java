package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repository;
    ProductManager manager;

    private Product[] products;


    @BeforeEach
    public void PrepareData() {
        repository = new ProductRepository();
        manager = new ProductManager(repository);
        products = new Product[4];

        products[0] = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        products[1] = new Book(2, "The Lord of the Rings: The Two Towers", 200, "Tolkien");
        products[2] = new Smartphone(3, "IPhone SE", 20000, "Apple");
        products[3] = new Smartphone(4, "IPhone 11", 70000, "Apple");

    }

    @Test
    public void shouldAddProduct(){
        Product product = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        manager.addProduct(product);

        assertEquals(product, manager.getRepository().findById(product.getId()));
    }

    @Test
    void shouldSearchBookName() {
        Product product = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        // Ожидаемый результат - продукт, который добавляем
        Product[] expected = {product};

        //Добавляем продукт через менеджер
        manager.addProduct(product);
        //Ищем по имени
        Product[] actual = manager.searchBy(product.getName());

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthor() {
        Product first = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        Product second = new Book(2, "The Lord of the Rings: The Two Towers", 200, "Tolkien");

        // Ожидаемый результат - массив из 2-х книг, у к-рых 1 автор
        Product[] expected = {first, second};

        //Добавляем продукты через менеджер
        manager.addProduct(first);
        manager.addProduct(second);

        String author = "Tolkien";
        Product[] actual = manager.searchBy(author);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneName() {
        Product first = new Smartphone(1, "IPhone", 20000, "Apple");
        Product second = new Smartphone(2, "IPhone", 70000, "Apple");

        Product[] expected = {first, second};

        //Добавляем продукты через менеджер
        manager.addProduct(first);
        manager.addProduct(second);

        Product[] actual = manager.searchBy(first.getName());

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchManufacturer() {
        Product first = new Smartphone(1, "IPhone SE", 20000, "Apple");
        Product second = new Smartphone(2, "IPhone 11", 70000, "Apple");

        Product[] expected = {first, second};

        //Добавляем продукты через менеджер
        manager.addProduct(first);
        manager.addProduct(second);

        String manufacturer = "Apple";
        Product[] actual = manager.searchBy(manufacturer);

        assertArrayEquals(expected, actual);
    }

}
