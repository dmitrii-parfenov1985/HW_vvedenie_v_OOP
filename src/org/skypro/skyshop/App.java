package org.skypro.skyshop;

import com.sun.source.doctree.SeeTree;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.MyComparator;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class App {

    public static void main(String[] args) {

        SimpleProduct grape = new SimpleProduct("виноград", 35);
        SimpleProduct orange = new SimpleProduct("апельсин", 15);
        SimpleProduct banana = new SimpleProduct("банан сочный", 20);
        SimpleProduct apple = new SimpleProduct("яблоко", 30);
        SimpleProduct orange3 = new SimpleProduct("апельсин", 15);

        DiscountedProduct milk = new DiscountedProduct("молоко", 90, 90 * 10 / 100);

        FixPriceProduct jeans = new FixPriceProduct("джинсы");
        FixPriceProduct trousers = new FixPriceProduct("брюки");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(grape);
        basket.addProduct(orange);
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(jeans);
        basket.addProduct(trousers);

        milk.isSpecial();
        banana.isSpecial();

        System.out.println(basket.totalPrice());
        System.out.println("__________________");
        System.out.println(basket.printBasket());
        System.out.println("__________________");

        Article articleAboutOrange = new Article("Статья о пользе апельсинов.", "В апельсинах много витамина С");
        Article articleAboutMilk = new Article("Статья о вреде молока: Молоко вредно для взрослых людей!", "Нельзя пить молоко!");
        Article articleAboutGrape = new Article("Статья о винограда : Из винограда делают вино", "Вино бывает белое и красное");
        Article orange12 = new Article("Апельсин 12", "12");
        Article orange2 = new Article("Апельсин 2", "2");


        System.out.println(articleAboutOrange.toString());
        System.out.println(articleAboutOrange.getSearchTerm());
        System.out.println(articleAboutOrange.getContentType());
        System.out.println(articleAboutOrange.getName());
        System.out.println(articleAboutMilk.getSearchTerm());
        System.out.println(banana.getSearchTerm());
        System.out.println(orange.getSearchTerm());
        System.out.println(apple.getName());
        System.out.println(articleAboutOrange);
        System.out.println(articleAboutGrape);

        SearchEngine searchEngine = new SearchEngine();

        try {
            searchEngine.findBestMatch("молоко");
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        searchEngine.add(orange);
        searchEngine.add(banana);
        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(jeans);
        searchEngine.add(articleAboutOrange);
        searchEngine.add(articleAboutMilk);
        searchEngine.add(orange2);
        searchEngine.add(orange12);
        TreeSet<Searchable> orangeSearchResult = searchEngine.search("апельсин");
        System.out.println(orangeSearchResult);
        System.out.println("-------");
        System.out.println(searchEngine.getSearchables());
        System.out.println("--------");
        System.out.println("compare " + searchEngine.compare(apple, milk));



        try {
            searchEngine.findBestMatch("молоко");
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        }

        for (Searchable searchable: searchEngine.search("апельсин")) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }

        for (Searchable searchable : searchEngine.search("молоко")) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }

        for (Object searchable: searchEngine.search("рубашка")) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }

        SearchEngine searchEngine1 = new SearchEngine();

        try {
            searchEngine1.findBestMatch("сочный яблоко молоко");
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        }
    }
}
