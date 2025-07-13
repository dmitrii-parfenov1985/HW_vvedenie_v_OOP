package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {


        SimpleProduct grape = new SimpleProduct("виноград", 35);

        SimpleProduct product1 = new SimpleProduct("апельсин", 15);
        SimpleProduct product3 = new SimpleProduct("банан", 20);
        SimpleProduct product4 = new SimpleProduct("яблоко", 30);

        DiscountedProduct product10 = new DiscountedProduct("молоко", 90, 90*10/100);

        FixPriceProduct product11 = new FixPriceProduct("джинсы");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(grape);
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


        Article article1 = new Article("Статья о пользе апельсинов.", " В апельсинах много витамина С");
        Article article2 = new Article("Название статьи: Молоко вредно для взрослых людей!", " Нельзя пить молоко!");

        System.out.println(article1.getSearchTerm());
        System.out.println(article1.getContentType());
        System.out.println(article1.getName());
        System.out.println(article2.getSearchTerm());
        System.out.println(product3.getSearchTerm());
        System.out.println(product1.getSearchTerm());
        System.out.println(product4.getName());
        System.out.println(article1);

        SearchEngine searchEngine = new SearchEngine();

        try {
            searchEngine.findBestMatch("апельсин");
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        }

        searchEngine.add(product1);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product10);
        searchEngine.add(product11);
        searchEngine.add(article1);
        searchEngine.add(article2);

        for (Searchable searchable : searchEngine.search("апельсин")) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }

        for (Searchable searchable : searchEngine.search("молоко")) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }

        for (Searchable searchable : searchEngine.search("рубашка")) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }
    }
}
