package com.clevertec_task.checks;

import com.clevertec_task.cards.Card;
import com.clevertec_task.cards.CardImpl;
import com.clevertec_task.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SimpleCheck implements Check {

    private final Map<Product, Integer> shoppingСart = new HashMap<>();

    @Override
    public Map<Product, Integer> getShoppingСart() {
        return shoppingСart;
    }

    @Override
    public BigDecimal generalСost() {
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Product product : shoppingСart.keySet()) {
            cost = cost.add(nominationCost(product, shoppingСart.get(product)));
        }
        return cost;
    }

    @Override
    public BigDecimal discountAmount(Card card, BigDecimal cost) {
        return cost.divide(card.getDiscount());
    }

    @Override
    public BigDecimal costWithDiscount(Card card, BigDecimal cost) {
        return cost.subtract(discountAmount(card, cost));
    }

    @Override
    public BigDecimal nominationCost(Product product, Integer value) {
        return product.getPrice().multiply(BigDecimal.valueOf(value));
    }
}
