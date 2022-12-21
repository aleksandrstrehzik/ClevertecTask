package com.clevertec_task.product.builders;

import com.clevertec_task.product.ProductBuilder;
import com.clevertec_task.product.Type;

import java.math.BigDecimal;

public class YogurtBuilder extends ProductBuilder {
    @Override
    public void marking() {
        product.setMarking("Protein, some fat, carbohydrates, water, bifidobacteria, vitamins and minerals");
    }

    @Override
    public void type() {
        product.setType(Type.MILK);
    }

    @Override
    public void price() {
        product.setPrice(BigDecimal.valueOf(56.26));
    }

    @Override
    public void discount() {
        product.setOnDiscount(true);
    }

    @Override
    public void description() {
        product.setDescription("Yogurt");
    }

    public void id() {
        product.setId(4);
    }
}
