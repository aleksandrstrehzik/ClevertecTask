/*
package com.clevertec_task.checks;

import com.clevertec_task.repository.entity.cards.Card;
import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.repository.factories.CardFactory;
import com.clevertec_task.repository.factories.ProductFactory;
import com.clevertec_task.service.impl.checks.SimpleCheck;
import com.clevertec_task.service.interfaces.checks.Check;
import com.clevertec_task.service.impl.store.StoreImpl;
import com.clevertec_task.service.interfaces.stores.Store;
import com.clevertec_task.service.utils.CheckUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCheckTest {

    private Check check;
    private CardFactory factory;
    private Store store;
    private String[] d = {"1-4", "2-4", "3-3", "44-4", "Card-1234"};
    private String[] a = {"wed"};

    @BeforeEach
    void init() {
        factory = new CardFactory();
        check = new SimpleCheck();
        store = new StoreImpl(new ProductFactory(), check, factory);
    }

    @Test
    void generalСost() {
        store.putProductsInCartByDirector(d);
        BigDecimal bigDecimal = check.generalСost();
        assertFalse(bigDecimal.equals(BigDecimal.valueOf(0)));
    }

    @Test
    void generalCostEqualsNull () {
        store.putProductsInCartByDirector(a);
        BigDecimal bigDecimal = check.generalСost();
        assertTrue(bigDecimal.equals(BigDecimal.valueOf(0)));
    }

    @Test
    void discountAmount() {
        store.putProductsInCartByDirector(d);
        BigDecimal generalСost = check.generalСost();
        Card card = factory.getCard(CheckUtil.getDiscountCard(d));
        BigDecimal discountAmount = check.discountAmount(card, generalСost);
        assertNotNull(discountAmount);
        BigDecimal divide = generalСost.divide(card.getDiscount());
        BigDecimal subtract = generalСost.subtract(discountAmount);
        assertEquals(subtract, generalСost.subtract(divide));
    }

    @Test
    void costWithDiscount() {
        store.putProductsInCartByDirector(d);
        BigDecimal generalСost = check.generalСost();
        Card card = factory.getCard(CheckUtil.getDiscountCard(d));
        BigDecimal costWithDiscount = check.costWithDiscount(card, generalСost);
        BigDecimal discountAmount = check.discountAmount(card, generalСost);
        assertTrue(costWithDiscount.equals(generalСost.subtract(discountAmount)));
    }

    @Test
    void nominationCost() {
        store.putProductsInCartByDirector(d);
        Map<Product, Integer> shoppingСart = check.getShoppingСart();
        for (Product product : shoppingСart.keySet()) {
            Integer val = shoppingСart.get(product);
            BigDecimal multiply = product.getPrice().multiply(BigDecimal.valueOf(val));
            assertEquals(check.nominationCost(product, val), multiply);
        }

    }

}*/
