package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product product = new Product(1, "Java I", 1000);

    @Test
    public void shouldSaveOneItem() {
        repository.save(product);

        Product[] expected = new Product[]{product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExist() {
        repository.save(product);
        repository.removeById(1);

        Product actual =repository.findAll();
        Product expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNoExist() {
        repository.save(product);

        assertThrows(NotFoundException.class, () -> repository.removeById(2));
    }
}