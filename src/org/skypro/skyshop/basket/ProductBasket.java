package org.skypro.skyshop.basket;

import org.skypro.skyshop.model.product.Product;

public class ProductBasket {

    private  Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт. Корзина переполнена.");
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
        for (int i = 0; i < products.length; i++) {
            System.out.println(i);
            products = null;
        }
    }
}