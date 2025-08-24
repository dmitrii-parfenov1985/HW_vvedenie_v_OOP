package org.skypro.skyshop.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Map<String, List<Product>> checkBasket (String search){
        Map<String, List<Product>> checkStream = nameToProduct.values().stream().flatMap(Collection::stream)
                .filter(product -> search.equals(product.getName()))
                .collect(Collectors.groupingBy(Product::getName));
        return checkStream;
    }
}