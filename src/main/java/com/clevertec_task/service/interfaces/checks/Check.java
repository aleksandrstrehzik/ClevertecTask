package com.clevertec_task.service.interfaces.checks;

import com.clevertec_task.repository.entity.cards.Card;
import com.clevertec_task.repository.entity.product.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface Check {
    Map<Product, Integer> getShoppingСart();

    BigDecimal generalСost();

    BigDecimal discountAmount(Card card, BigDecimal cost);

    BigDecimal costWithDiscount(Card card, BigDecimal cost);

    BigDecimal nominationCost(Product product, Integer value);
}
