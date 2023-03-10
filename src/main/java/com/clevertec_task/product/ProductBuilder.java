package com.clevertec_task.product;

public abstract class ProductBuilder {

    protected Product product;

    public Product getProduct() {
        return product;
    }

    public void createProduct() {
        product = new ProductImpl();
    }

    public abstract void marking();
    public abstract void type();
    public abstract void price();
    public abstract void discount();
    public abstract void description();
    public abstract void id();
}
