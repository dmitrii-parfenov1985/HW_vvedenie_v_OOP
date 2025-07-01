package org.skypro.skyshop.model.product;

public class DiscountedProduct extends Product {

    public int basePrice;
    public int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Такой цены нет на этот товар!");
        }
        // проверка discount
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка не может быть отрицательной или более 100 % !");
        }
    }

    @Override
    public int getPrice() {
        return basePrice - discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " со скидкой: " + getPrice() + " скидка: " + discount + " %";
    }

}
