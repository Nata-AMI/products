package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product product = new Product(1, "Java I", 1000);

    @Test
    public void shouldSaveOneItem() {
        repository.save("Java I");

        Product[] expected = new Product[]{"Java I"};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExist(int id) {
        repository.save("Java I");
        Product[] products = repository.findById(1);

        Product actual = repository.findById(1);
        Product expected = new Product[]{"Java I"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNoExist(int id) {
        repository.save("Java I");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(2));
    }
}