package com.clevertec_task.cards;

import java.math.BigDecimal;

public interface Card {
    BigDecimal getDiscount();

    void setDiscount(BigDecimal discount);

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

}
