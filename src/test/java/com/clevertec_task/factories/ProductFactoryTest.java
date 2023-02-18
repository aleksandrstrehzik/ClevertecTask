package com.clevertec_task.factories;

import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.repository.factories.ProductFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    private ProductFactory factory;

    @BeforeEach
    void init() {
        factory = new ProductFactory();
    }

    @Test
    void getProductById() {
        Product product = factory.getProduct(1);
        assertNotNull(product);
    }

    void IdNotExist() {
        Product product = factory.getProduct(0);
        assertNull(product);
    }
}