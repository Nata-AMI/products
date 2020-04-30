package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    @Test
    public void shouldRemoveByIdIfExist(int id) {
        Product product = new Product(1, "Java I", 1000);
         assertEquals(1, ProductRepository.removeById(1));


    }
}
