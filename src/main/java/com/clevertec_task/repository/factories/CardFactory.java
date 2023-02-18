package com.clevertec_task.repository.factories;

import com.clevertec_task.repository.entity.cards.Card;

import java.math.BigDecimal;

public class CardFactory {

    public Card getCard(String card) {
        switch (card) {
            case "Card-1234":
                return new Card(BigDecimal.valueOf(10), 1, "Card-1234");
            default: return null;
        }
    }
}
