package com.clevertec_task.checks;

import com.clevertec_task.cards.Card;
import com.clevertec_task.cards.CardImpl;
import com.clevertec_task.factories.CardFactory;
import com.clevertec_task.factories.ProductFactory;
import com.clevertec_task.store.Store;
import com.clevertec_task.store.StoreImpl;
import com.clevertec_task.util.CheckUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CheckWithDiscountTest {
    private Check check;
    private CardFactory factory;
    private Store store;
    private String[] d = {"1-4", "2-4", "3-3", "44-4", "Card-1234"};
    private String[] a = {"wed"};

    @BeforeEach
    void init() {
        factory = new CardFactory();
        check = new SimpleCheck();
        store = new StoreImpl("IGu", new ProductFactory(), check, factory);
    }

    @Test
    void generalСost() {
        store.putProductsInCartByDirector(d);
        check = new CheckWithDiscount(check);
        BigDecimal bigDecimal = check.generalСost();
        assertFalse(bigDecimal.equals(BigDecimal.valueOf(0)));
    }

    @Test
    void generalCostEqualsNull () {
        store.putProductsInCartByDirector(a);
        check = new CheckWithDiscount(check);
        BigDecimal bigDecimal = check.generalСost();
        assertTrue(bigDecimal.equals(BigDecimal.valueOf(0)));
    }

    @Test
    void discountAmount() {
        store.putProductsInCartByDirector(d);
        check = new CheckWithDiscount(check);
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
        check = new CheckWithDiscount(check);
        BigDecimal generalСost = check.generalСost();
        Card card = factory.getCard(CheckUtil.getDiscountCard(d));
        BigDecimal costWithDiscount = check.costWithDiscount(card, generalСost);
        BigDecimal discountAmount = check.discountAmount(card, generalСost);
        assertTrue(costWithDiscount.equals(generalСost.subtract(discountAmount)));
    }

}