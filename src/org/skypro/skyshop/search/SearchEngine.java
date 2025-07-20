package org.skypro.skyshop.search;

import java.util.*;


public class SearchEngine {

    private final List<Searchable> searchables = new LinkedList<>();

    public SearchEngine() {
    }

    public List<Searchable> getSearchables() {
        return searchables;
    }


    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String search) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(search)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public List<Searchable> delete(String search) {
        Iterator<Searchable> iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            System.out.println(element);
        }
        return List.of();
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
