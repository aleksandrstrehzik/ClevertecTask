package com.clevertec_task.product.builders;

import com.clevertec_task.product.ProductBuilder;
import com.clevertec_task.product.Type;

import java.math.BigDecimal;

public class BunBuilder extends ProductBuilder {
    @Override
    public void marking() {
        product.setMarking("Flour, water, raisin, sugar and salt");
    }

    @Override
    public void type() {
        product.setType(Type.BAKE);
    }

    @Override
    public void price() {
        product.setPrice(BigDecimal.valueOf(5.5));
    }

    @Override
    public void discount() {
        product.setOnDiscount(false);
    }


    @Override
    public void description() {
        product.setDescription("Bun");
    }

    public void id() {
        product.setId(2);
    }
}
