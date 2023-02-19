package com.clevertec_task.service.impl.checks;

import com.clevertec_task.repository.entity.cards.Card;
import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.service.interfaces.checks.Check;

import java.math.BigDecimal;
import java.util.Map;

public class CheckWithDiscount implements Check {

    private Check check;
    private Map<Product, Integer> shoppingСart;


    public CheckWithDiscount(Check check) {
        this.check = check;
    }

    @Override
    public Map<Product, Integer> getShoppingСart() {
        return shoppingСart;
    }

    @Override
    public BigDecimal generalСost() {
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Product product : check.getShoppingСart().keySet()) {
            Integer value = check.getShoppingСart().get(product);
            if (value >= 5 && product.IsOnDiscount()) {
                cost = cost.add(nominationCost(product, value));
            } else {
                cost = cost.add(check.nominationCost(product, value));
            }
        }
        return cost;
    }

    @Override
    public BigDecimal discountAmount(Card card, BigDecimal cost) {
        return (check.generalСost().subtract(cost)).add(cost.divide(card.getDiscount()));
    }

    @Override
    public BigDecimal costWithDiscount(Card card, BigDecimal cost) {
        return cost.subtract(discountAmount(card, cost));
    }


    @Override
    public BigDecimal nominationCost(Product product, Integer value) {
        return product.getPrice().multiply(BigDecimal.valueOf(value)).multiply(BigDecimal.valueOf(0.9));
    }
}
