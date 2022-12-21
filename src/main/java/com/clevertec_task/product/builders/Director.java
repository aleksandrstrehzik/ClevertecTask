package com.clevertec_task.product.builders;

import com.clevertec_task.product.Product;
import com.clevertec_task.product.ProductBuilder;

public class Director {
    private ProductBuilder productBuilder;

    public  void setProductBuilder(ProductBuilder p) {
        productBuilder = p;
    }

    public Product build() {
        productBuilder.createProduct();
        productBuilder.marking();
        productBuilder.type();
        productBuilder.price();
        productBuilder.discount();
        productBuilder.description();
        productBuilder.id();
        return productBuilder.getProduct();
    }
}
