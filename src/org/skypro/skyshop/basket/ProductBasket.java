package org.skypro.skyshop.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {

    private List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        for (int i = 0; products.size() > i; i++) {
            if (products.get(i) == null) {
                products.set(i, product);
                return;
            }
        }
    }

    public int totalPrice() {
        int summ = 0;
        for (Product product : products) {
            if (product != null) {
                summ = summ + product.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + totalPrice());
    }

    public boolean checkBasket(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                System.out.println("Такой продукт уже лежит в корзине");
                return true;
            }
        }
        return false;
    }

    public void deleteBasket() {
        for (int i = 0; i < Objects.requireNonNull(products).size(); i++) {
            System.out.println(i);
            products = null;
        }
    }
}