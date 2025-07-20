package org.skypro.skyshop.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.*;

public class ProductBasket {

    public Map<String, List<Product>> nameToProduct = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> currentValue = nameToProduct.get(product.getName());
        if (currentValue == null) {
            currentValue = new ArrayList<>();
            nameToProduct.put(product.getName(), currentValue);
        }
        currentValue.add(product);
    }

    // переписать через entrySet
    public int totalPrice() {
        int result = 0;
        for (Map.Entry<String, List<Product>> mapEntry : nameToProduct.entrySet()) {
            for (Product product : mapEntry.getValue()) {
                result = result + product.getPrice();
            }
        }
        return result;
    }

    public boolean printBasket() {
        for (Map.Entry<String, List<Product>> mapPrint : nameToProduct.entrySet()) {
            for (Product product : mapPrint.getValue()) {
                System.out.println(product);
            }
        }
        return true;
    }

    public boolean checkBasket (String search){
            if ((search != null) && nameToProduct.containsKey(search)) {
                System.out.println("Такой продукт уже лежит в корзине");
                return true;
            }
        return false;
    }
}




//
//        public void deleteBasket () {
//            for (int i = 0; i < Objects.requireNonNull(products).size(); i++) {
//                System.out.println(i);
//                products = null;
//            }
//        }