package org.skypro.skyshop.search;

import org.skypro.skyshop.model.product.Product;


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

    public Searchable[] search(String search) {
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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable max = null;
        int currentMax = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int count = count(searchable.getSearchTerm(), search);
                if (max == null || currentMax < count) {
                    max = searchable;
                    currentMax = count;
                }
            }
        }
        if (max == null) {
            throw new BestResultNotFound(search);
        }
        return max;
    }

    public int count(String str, String substring) {
        int count = 0;
        int index = 0;
        int indexSubstring = str.indexOf(substring, index);

        while (indexSubstring != -1) {
            count++;
            index = indexSubstring + substring.length();
            indexSubstring = str.indexOf(substring, index);
        }
        return count;
    }
}
