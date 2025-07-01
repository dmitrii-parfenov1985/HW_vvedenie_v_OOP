package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        SimpleProduct simpleProduct1 = new SimpleProduct("апельсин", 15);
        SimpleProduct simpleProduct2 = new SimpleProduct("банан", 20);
        SimpleProduct simpleProduct3 = new SimpleProduct("яблоко", 30);
        SimpleProduct simpleProduct4 = new SimpleProduct("лимон", 40);

        DiscountedProduct discountedProduct1 = new DiscountedProduct("молоко", 90, 90*10/100);

        FixPriceProduct fixPriceProduct1 = new FixPriceProduct("джинсы");

        ProductBasket basket = new ProductBasket();



        basket.addProduct(simpleProduct1);
        basket.addProduct(simpleProduct2);
        basket.addProduct(simpleProduct3);
        basket.addProduct(discountedProduct1);
        basket.addProduct(simpleProduct4);

        discountedProduct1.isSpecial();
        simpleProduct3.isSpecial();


        System.out.println(basket.totalPrice());
        basket.printBasket();
        basket.checkBasket("апельсин");
        basket.deleteBasket();

        Article article1 = new Article("Статья о пользе апельсинов.", " В апельсинах много витамина С");
        Article article2 = new Article("Название статьи: Молоко вредно для взрослых людей!", " Нельзя пить молоко!");

        System.out.println(article1.getSearchTerm());
        System.out.println(article1.getContentType());
        System.out.println(article1.getName());
        System.out.println(article2.getSearchTerm());
        System.out.println(simpleProduct3.getSearchTerm());
        System.out.println(simpleProduct1.getSearchTerm());
        System.out.println(simpleProduct4.getName());
        System.out.println(article1);

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(simpleProduct1);
        searchEngine.add(simpleProduct3);
        searchEngine.add(simpleProduct4);
        searchEngine.add(discountedProduct1);
        searchEngine.add(fixPriceProduct1);
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
        SimpleProduct simpleProduct22 = new SimpleProduct("лук", 30);
        SimpleProduct simpleProduct33 = new SimpleProduct("морковь", 50);

        DiscountedProduct discountedProduct2 = new DiscountedProduct("хлеб", 100, 80 * 10 / 100);
        try {
            searchEngine.add(discountedProduct2);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        System.out.println(simpleProduct22);
        System.out.println(simpleProduct33);
    }
}
