package org.skypro.skyshop.model.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private String name;



    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Введите корректное название продукта!");
        }
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

    public String getSearchTerm() {
        return getName();
    }

    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;

        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
