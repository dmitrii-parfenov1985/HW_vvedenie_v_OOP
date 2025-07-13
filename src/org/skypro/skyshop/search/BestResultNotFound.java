package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {

    private String search;

    public BestResultNotFound(String search) {
        super(search);
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{" +
                "search='" + search + '\'' +
                '}';
    }
}
