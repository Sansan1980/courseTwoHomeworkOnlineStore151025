package org.skypro.skyshop.service;

import org.skypro.skyshop.model.Product;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> productBasketsMap;

    public ProductBasket() {
        this.productBasketsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        String key = creatingKeyTheBasketMap(product.getNameProduct());
        if (!productBasketsMap.containsKey(key)) {
            List<Product> productBasketsList = new ArrayList<>();
            productBasketsList.add(product);
            productBasketsMap.put(key, productBasketsList);
        } else {
            List<Product> productBasketsList = productBasketsMap.get(key);
            productBasketsList.add(product);
        }


    }

    public List<Product> deleteProductByName(String nameProduct) {
        List<Product> deletedProductByName = new ArrayList<>();
        String key = creatingKeyTheBasketMap(nameProduct);
        if (!productBasketsMap.containsKey(key)) {
            System.out.println("По данному запросу - " + nameProduct + ", нет такого списка продуктов");
        } else {
            deletedProductByName = productBasketsMap.remove(key);
        }
        return deletedProductByName;
    }

    public int generalPraisBascet() {
        int summ = 0;
        int productList = productBasketsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(product -> product.getPrice())
                .sum();

        return productList;
    }

    public void printBascet() {
        //int isSpecialCounter = 0;
        if (productBasketsMap.isEmpty()) {
            System.out.println("«В корзине пусто»");
            return;
        }


        productBasketsMap.values().stream().flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: <общая стоимость корзины = " + generalPraisBascet() + " >");
        SpecialCount();
    }

    private void SpecialCount() {
    long isSpecialCounter = productBasketsMap.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        System.out.println("Специальных товаров: " + isSpecialCounter);
    }


    public boolean searchByNameProductInBasket(String nameProduct) {
        boolean searchName = false;
        String key = creatingKeyTheBasketMap(nameProduct);
        if (!productBasketsMap.containsKey(key)) {
            System.out.println("По данному запросу - " + nameProduct + ", не такого списка продуктов");
        } else {
            searchName = true;
        }
        return searchName;
    }

    public void cleaningBascet() {
        productBasketsMap.clear();
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBaskets=" + productBasketsMap +
                '}';
    }


    public String creatingKeyTheBasketMap(String name) {
        return name;
    }
}

