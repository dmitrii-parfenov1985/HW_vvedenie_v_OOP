package org.skypro.skyshop.product;

public class SearchEngine {

    private Searchable[] searchables = new Searchable[5];

    public SearchEngine(Searchable[] searchables) {
        this.searchables = searchables;
    }

    public Searchable[] getSearchables() {
        return searchables;
    }

    public String search(String search){
        for (Searchable searchable : searchables) {
            return searchable.contentType();
        }
        return search;
    }

}
