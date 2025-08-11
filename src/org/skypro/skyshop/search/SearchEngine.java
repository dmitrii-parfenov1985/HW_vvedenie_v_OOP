package org.skypro.skyshop.search;

import java.util.*;


public class SearchEngine implements Comparator {

    private final Set<Searchable> searchables = new HashSet<>();

    public SearchEngine() {
    }

    public Set<Searchable> getSearchables() {
        return searchables;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SearchEngine)) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchables);
    }

    public TreeSet<Searchable> search(String search) {
        TreeSet<Searchable> result = new TreeSet<>(new MyComparator());
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(search)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public List<Searchable> delete(String search) {
        Iterator<Searchable> iterator = searchables.iterator();
        List<Searchable> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            if (element != null && element.getSearchTerm().contains(search)){
                iterator.remove();
                result.add(element);
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

