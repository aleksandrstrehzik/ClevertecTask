package com.clevertec_task.cards;

import java.math.BigDecimal;

public class CardImpl implements Card {
    private BigDecimal discount;
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CardImpl{" +
                "discount=" + discount +
                ", id=" + id +
                '}';
    }

    public CardImpl() {
    }

    @Override
    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public CardImpl(BigDecimal discount, Integer id, String name) {
        this.discount = discount;
        this.id = id;
        this.name = name;
    }
}
