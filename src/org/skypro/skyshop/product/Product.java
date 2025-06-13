package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

    private String name;


    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();


    public String toString() {
        return "В корзине: " + name + " цена: " + getPrice();
    }

    public String searchTerm() {
        return getName();
    }

    public String contentType() {
        return "PRODUCT";
    }
}
