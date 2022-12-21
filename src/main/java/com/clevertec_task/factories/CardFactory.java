package com.clevertec_task.factories;

import com.clevertec_task.cards.Card;
import com.clevertec_task.cards.CardImpl;

import java.math.BigDecimal;

public class CardFactory {

    public Card getCard(String card) {
        switch (card) {
            case "Card-1234":
                return new CardImpl(BigDecimal.valueOf(10), 1, "Card-1234");
            default: return null;
        }
    }
}
