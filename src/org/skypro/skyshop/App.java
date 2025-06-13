package org.skypro.skyshop;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        SimpleProduct product1 = new SimpleProduct("апельсин", 15);
        SimpleProduct product3 = new SimpleProduct("банан", 20);
        SimpleProduct product4 = new SimpleProduct("яблоко", 30);

        DiscountedProduct product10 = new DiscountedProduct("молоко", 90, 90 * 10 / 100);

        FixPriceProduct product11 = new FixPriceProduct("джинсы");

        ProductBasket basket = new ProductBasket();


        basket.addProduct(product1);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product10);
        basket.addProduct(product11);

        product10.isSpecial();
        product3.isSpecial();

        System.out.println(basket.totalPrice());
        basket.printBasket();
        basket.checkBasket("апельсин");
        basket.deleteBasket();

        Article article1 = new Article("Статья о пользе апельсинов.", " В апельсинах много витамина С");
        Article article2 = new Article("Название статьи: Молоко вредно для взрослых людей!", " Нельзя пить молоко!");

        System.out.println(article1.searchTerm());
        System.out.println(article1.contentType());
        System.out.println(article1.getName());
        System.out.println(article2.searchTerm());
        System.out.println(product3.searchTerm());
        System.out.println(product1.searchTerm());
        System.out.println(product4.getName());
        System.out.println(article1.toString());
    }
}
