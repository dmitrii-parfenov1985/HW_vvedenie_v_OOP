package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.Objects;
import java.util.Set;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text + "\n";
    }

    @Override
    public String getSearchTerm() {
        return getTitle() + getText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;

        return Objects.equals(title, article.title);
    }

    public int hashCode() {
        return Objects.hashCode(title);
    }
}
