package com.clevertec_task.repository.entity.cards;

import java.math.BigDecimal;

public class Card {
    private BigDecimal discount;
    private Integer id;
    private String name;

    public Card() {
    }

    public Card(BigDecimal discount, Integer id, String name) {
        this.discount = discount;
        this.id = id;
        this.name = name;
    }

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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
