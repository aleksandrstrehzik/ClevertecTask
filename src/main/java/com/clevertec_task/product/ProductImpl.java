package com.clevertec_task.product;

import java.math.BigDecimal;

public class ProductImpl implements Product {

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

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public ProductImpl() {
    }

    @Override
    public boolean IsOnDiscount() {
        return IsOnDiscount;
    }

    @Override
    public void setOnDiscount(boolean onDiscount) {
        IsOnDiscount = onDiscount;
    }

    @Override
    public void setMarking(String marking) {
        this.marking = marking;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
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
