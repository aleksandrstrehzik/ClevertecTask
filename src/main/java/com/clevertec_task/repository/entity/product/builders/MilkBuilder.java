package com.clevertec_task.repository.entity.product.builders;

import com.clevertec_task.repository.entity.product.ProductBuilder;
import com.clevertec_task.repository.entity.product.Type;

import java.math.BigDecimal;

public class MilkBuilder extends ProductBuilder {
    @Override
    public void marking() {
        product.setMarking("Ingredients: water, fat, proteins, lactose (milk sugar) and minerals (salts)");
    }

    @Override
    public void type() {
        product.setType(Type.MILK);
    }

    @Override
    public void price() {
        product.setPrice(BigDecimal.valueOf(34.22));
    }

    @Override
    public void discount() {
        product.setOnDiscount(false);
    }

    @Override
    public void description() {
        product.setDescription("Milk");
    }

    public void id() {
        product.setId(3);
    }
}
