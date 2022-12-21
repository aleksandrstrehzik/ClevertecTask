package com.clevertec_task.product;

import java.math.BigDecimal;

public interface Product {
    String getDescription();

    Integer getId();

    String getMarking();

    Type getType();

    void setId(Integer id);

    void setDescription(String description);

    boolean IsOnDiscount();

    void setOnDiscount(boolean onDiscount);

    void setMarking(String marking);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    void setType(Type type);

    @Override
    String toString();
}
