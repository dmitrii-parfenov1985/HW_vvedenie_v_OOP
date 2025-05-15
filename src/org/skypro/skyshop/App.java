package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        Product product1 = new Product("апельсин", 15);
        Product product2 = new Product("лимон", 10);
        Product product3 = new Product("банан", 20);
        Product product4 = new Product("яблоко", 30);
        Product product5 = new Product("манго", 50);
        Product product6 = new Product("манго", 50);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        System.out.println(basket.totalPrice());
        basket.printBasket();
        basket.checkBasket("апельсин");
        basket.deleteBasket();

    }
}
