package org.skypro.skyshop;

import com.sun.source.doctree.SeeTree;
import com.sun.source.tree.Tree;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {

        SimpleProduct grape = new SimpleProduct("виноград", 35);
        SimpleProduct orange = new SimpleProduct("апельсин", 15);
        SimpleProduct banana = new SimpleProduct("банан сочный", 20);
        SimpleProduct apple = new SimpleProduct("яблоко", 30);
        SimpleProduct orange2 = new SimpleProduct("апельсин", 15);

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
        Article articleAboutMilk = new Article("Название статьи: Молоко вредно для взрослых людей!", "Нельзя пить молоко!");
        Article articleAboutGrape = new Article("Статья о винограда : Из винограда делают вино", "Вино бывает белое и красное");

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
        System.out.println("-------------");

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
        System.out.println("-------");
        TreeSet<Searchable> orangeSearchResult = searchEngine.search("апельсин");
        System.out.println(orangeSearchResult);
        System.out.println("-------");
//        System.out.println(searchEngine.delete("апельсин"));

//        System.out.println(searchEngine.delete("молоко"));
        System.out.println(searchEngine.delete("брюки"));
        System.out.println(searchEngine.getSearchables());
        System.out.println("--------");
        System.out.println("начало метода search");
        System.out.println(searchEngine.search("молоко"));
        System.out.println(searchEngine.search("банан"));
        System.out.println("конец метода search");

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

        for (Searchable searchable: searchEngine.search("рубашка")) {
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
