package org.skypro.skyshop.product;

public abstract class Product {

    private String name;



    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public String getName() {
        return name;
    }

    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return "В корзине: " + name + " цена: " + getPrice();
    }

}
