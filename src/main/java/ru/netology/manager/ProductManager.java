package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        if (text == null || text.isEmpty()) {
            return result;
        }

        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        boolean result = false;

        if (product instanceof Book) {
            Book book = (Book) product;
            String name = book.getName();
            String author = book.getAuthor();

            if (name != null && !name.isEmpty() && name.equalsIgnoreCase(search) ||
                    author != null && !author.isEmpty() && author.equalsIgnoreCase(search)) {
                result = true;
            }

        } else if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            String name = smartphone.getName();
            String manufacturer = smartphone.getManufacturer();

            if (name != null && !name.isEmpty() && name.equalsIgnoreCase(search) ||
                    manufacturer != null && !manufacturer.isEmpty() && manufacturer.equalsIgnoreCase(search)) {
                result = true;
            }

        }

        return result;
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }
}
