package org.skypro.skyshop.search;

import java.util.Comparator;

public class MyComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        String s1 = o1.getName();
        String s2 = o2.getName();
        int c1 = Integer.compare(s1.length(), s2.length());
        if (c1 == 0) {
            return s1.compareTo(s2);
        }
        return c1;
    }
}
