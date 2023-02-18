package com.clevertec_task.repository.factories;

import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.repository.entity.product.ProductBuilder;
import com.clevertec_task.repository.entity.product.builders.*;

public class ProductFactory {

    public Product getProduct(Integer id) {
        Director director = new Director();
        ProductBuilder someProduct = null;
        switch (id) {
            case 1:
                someProduct = new BreadBuilder();
                break;
            case 2:
                someProduct = new BunBuilder();
                break;
            case 3:
                someProduct = new MilkBuilder();
                break;
            case 4:
                someProduct = new YogurtBuilder();
                break;
            default:
                System.out.println("No product with id=" + id);
                return null;
        }
        director.setProductBuilder(someProduct);
        return director.build();
    }
}
