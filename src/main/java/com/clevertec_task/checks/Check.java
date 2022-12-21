package com.clevertec_task.checks;



import com.clevertec_task.cards.Card;
import com.clevertec_task.cards.CardImpl;
import com.clevertec_task.product.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface Check {
    Map<Product, Integer> getShoppingСart();

    BigDecimal generalСost();

    BigDecimal discountAmount(Card card, BigDecimal cost);

    BigDecimal costWithDiscount(Card card, BigDecimal cost);

    BigDecimal nominationCost(Product product, Integer value);
}
