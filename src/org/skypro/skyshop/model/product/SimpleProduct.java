package org.skypro.skyshop.model.product;

public class SimpleProduct extends Product {

    public int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        //проверка price
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть ноль или отрицательной!");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
