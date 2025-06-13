package org.skypro.skyshop.product;

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
    public String searchTerm() {
        return getTitle() + getText();
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return "Строка - Имя продукта";
    }
}
