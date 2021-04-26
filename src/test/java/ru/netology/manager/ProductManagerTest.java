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
    Product[] products;

    @BeforeEach
    public void PrepareData() {
        repository = new ProductRepository();
        manager = new ProductManager(repository);
        products = new Product[4];
        products[0] = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        products[1] = new Book(2, "The Lord of the Rings: The Two Towers", 200, "Tolkien");
        products[2] = new Smartphone(3, "IPhone", 20000, "Apple");
        products[3] = new Smartphone(4, "IPhone", 70000, "Apple");
    }

    @Test
    public void shouldSetRepository(){
        manager.setRepository(repository);

        assertNotNull(manager.getRepository());
    }

    @Test
    public void shouldAddProduct(){
        Product product = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        manager.addProduct(product);

        assertEquals(product, manager.getRepository().findById(product.getId()));
    }

    @Test
    public void shouldSearchNullText(){
        Product product = new Book(1, null, 100, null);
        manager.addProduct(product);

        Product[] actual = manager.searchBy(product.getName());

        assertEquals(actual.length, 0);
    }

    @Test
    public void shouldSearchEmptyText(){
        Product product = new Book(1, "", 100, "");
        manager.addProduct(product);

        Product[] actual = manager.searchBy(product.getName());

        assertEquals(actual.length, 0);
    }

    @Test
    public void shouldSearchBookName() {
         // Ожидаемый результат - продукт, который добавляем
        Product[] expected = {products[0]};

        //Добавляем продукт через менеджер
        manager.addProduct(products[0]);
        manager.addProduct(products[1]);
        manager.addProduct(products[2]);
        manager.addProduct(products[3]);
        //Ищем по имени
        Product[] actual = manager.searchBy(products[0].getName());

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIncorrectBookName() {
        Product product = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 200, "Tolkien");
        // Ожидаемый результат - продукт, который добавляем
        Product[] expected = new Product[]{};

        //Добавляем продукт через менеджер
        manager.addProduct(product);
        //Ищем по имени
        String name = "Ring";
        Product[] actual = manager.searchBy(name);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthor() {
        // Ожидаемый результат - массив из 2-х книг, у к-рых 1 автор
        Product[] expected = {products[0], products[1]};

        //Добавляем продукты через менеджер
        manager.addProduct(products[0]);
        manager.addProduct(products[1]);
        manager.addProduct(products[2]);
        manager.addProduct(products[3]);

        String author = "Tolkien";
        Product[] actual = manager.searchBy(author);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneName() {
        Product[] expected = {products[2], products[3]};

        //Добавляем продукты через менеджер
        manager.addProduct(products[0]);
        manager.addProduct(products[1]);
        manager.addProduct(products[2]);
        manager.addProduct(products[3]);

        Product[] actual = manager.searchBy(products[2].getName());

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIncorrectName() {
        Product[] expected = {};

        //Добавляем продукты через менеджер
        manager.addProduct(products[0]);
        manager.addProduct(products[1]);
        manager.addProduct(products[2]);
        manager.addProduct(products[3]);

        String name = "Samsung";
        Product[] actual = manager.searchBy(name);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchManufacturer() {
        Product[] expected = {products[2], products[3]};

        //Добавляем продукты через менеджер
        manager.addProduct(products[0]);
        manager.addProduct(products[1]);
        manager.addProduct(products[2]);
        manager.addProduct(products[3]);


        String manufacturer = "Apple";
        Product[] actual = manager.searchBy(manufacturer);

        assertArrayEquals(expected, actual);
    }

}
