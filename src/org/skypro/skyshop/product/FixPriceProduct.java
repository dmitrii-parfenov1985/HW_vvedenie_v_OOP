package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    public FixPriceProduct(String name) {
        super(name);
    }

    private static final int FIX_PRICE = 100;

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " с фиксированной ценой: " + FIX_PRICE;
    }

}
