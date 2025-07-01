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

        SimpleProduct orange = new SimpleProduct("сочный апельсин", 15);
        SimpleProduct banana = new SimpleProduct("банан", 20);
        SimpleProduct apple = new SimpleProduct("сочный яблоко", 30);
        SimpleProduct lemon = new SimpleProduct("сочный лимон сочный", 40);

        DiscountedProduct milk = new DiscountedProduct("молоко", 90, 90*10/100);

        FixPriceProduct jeans = new FixPriceProduct("джинсы");

        ProductBasket basket = new ProductBasket();


        basket.addProduct(orange);
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(lemon);

        milk.isSpecial();
        apple.isSpecial();


        System.out.println(basket.totalPrice());
        basket.printBasket();
        basket.checkBasket("апельсин");
//        basket.deleteBasket();
        System.out.println("App.main");
        basket.printBasket();

        Article articleOrange = new Article("Статья о пользе апельсинов.", " В апельсинах много витамина С");
        Article articleMilk = new Article("Название статьи: Молоко вредно для взрослых людей!", " Нельзя пить молоко!");

        System.out.println(articleOrange.getSearchTerm());
        System.out.println(articleOrange.getContentType());
        System.out.println(articleOrange.getName());
        System.out.println(articleMilk.getSearchTerm());
        System.out.println(apple.getSearchTerm());
        System.out.println(orange.getSearchTerm());
        System.out.println(lemon.getName());
        System.out.println(articleOrange);

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(orange);
        searchEngine.add(apple);
        searchEngine.add(lemon);
        System.out.println("----");
        try {
            System.out.println(searchEngine.findBestMatch("фрукт"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        searchEngine.add(milk);
        searchEngine.add(jeans);
        searchEngine.add(articleOrange);
        searchEngine.add(articleMilk);
        System.out.println("App.main");
        searchEngine.search("апельсин");

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
        SimpleProduct onion = new SimpleProduct("лук", 30);
        SimpleProduct carrot = new SimpleProduct("морковь", 50);

        DiscountedProduct discountedProduct2 = new DiscountedProduct("хлеб", 100, 80 * 10 / 100);
        try {
            searchEngine.add(discountedProduct2);
        } catch (Exception e) {
            throw new RuntimeException();
        }

//        String str = "helllhhhoooeelolheeolnjdsfvkjadfg";
//        String substring = "hello";
//        int quantity = 0;
//        int index = 0;
//        int substringIndex = str.indexOf(substring, index);

        System.out.println(onion);
        System.out.println(carrot);
    }
}
