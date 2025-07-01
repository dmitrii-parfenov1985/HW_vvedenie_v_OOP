package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchables = new Searchable[10];

    public SearchEngine() {
        this.searchables = searchables;
    }

    public Searchable[] getSearchables() {
        return searchables;
    }


    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
    }

    public Searchable[] search(String search){
        Searchable[] result = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {
            if (count >= 5) {
                break;
            }
            if (searchable != null && searchable.getSearchTerm().contains(search)) {
                result[count] = searchable;
                count++;
            }
        }
        return result;
    }

}
