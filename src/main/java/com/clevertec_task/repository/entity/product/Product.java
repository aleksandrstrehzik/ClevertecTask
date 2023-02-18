package com.clevertec_task.repository.entity.product;

import java.math.BigDecimal;

public class Product {

    private boolean IsOnDiscount;
    private String marking;
    private BigDecimal price;
    private Type type;
    private String description;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarking() {
        return marking;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
    }

    public boolean IsOnDiscount() {
        return IsOnDiscount;
    }

    public void setOnDiscount(boolean onDiscount) {
        IsOnDiscount = onDiscount;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return "ProductImpl{" +
                "IsOnDiscount=" + IsOnDiscount +
                ", marking='" + marking + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
