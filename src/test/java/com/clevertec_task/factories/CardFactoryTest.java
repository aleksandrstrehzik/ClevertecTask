package com.clevertec_task.factories;

import com.clevertec_task.repository.entity.cards.Card;
import com.clevertec_task.repository.factories.CardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest {

    private CardFactory factory;
    private String card = "Card-1234";
    private String noCard = "Car";

    @BeforeEach
    void init() {
        factory = new CardFactory();
    }

    @Test
    void getCard() {
        Card card = factory.getCard(this.card);
        assertNotNull(card);
    }


    @Test
    void cardNotExist() {
        Card card = factory.getCard(noCard);
        assertNull(card);
    }
}