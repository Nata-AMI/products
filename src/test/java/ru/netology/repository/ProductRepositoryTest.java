package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.excertion.NotFoundException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExist(int id) {
        repository.save(coreJava);
        int idToRemove = 1;
        Product product = new Product(1, "Java I", 1000);
        Product actual = repository.removeById(idToRemove);
        Product expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNoExist(int id) {
        repository.save(coreJava);
        int idToRemove = 2;
        Product product = new Product(1, "Java I", 1000);
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }
}