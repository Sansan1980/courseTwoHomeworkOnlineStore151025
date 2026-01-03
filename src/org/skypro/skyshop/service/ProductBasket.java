package org.skypro.skyshop.service;

import org.skypro.skyshop.model.Product;

import java.util.*;

public class ProductBasket {
    private final List<Product> productBaskets;
    private int counterBascet;

    public ProductBasket() {
        this.productBaskets = new LinkedList<>();
    }

    public void addProduct(Product product) {
        productBaskets.add(product);
        counterBascet = counterBascet + 1;
    }

    public List<Product> deleteProductByName(String nameProduct) {
        List<Product> listDeleteProductByName = new LinkedList<>();
        Iterator<Product> iterator = productBaskets.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getNameProduct().equals(nameProduct)) {
                System.out.println("ProductBasket.deleteProductByName " + element);
                listDeleteProductByName.add(element);
                iterator.remove();
            }
        }
        if (listDeleteProductByName.isEmpty()) {
            System.out.println("Список пуст");
        }
        return listDeleteProductByName;
    }


    public int generalPraisBascet() {
        int summ = 0;
        for (Product p : productBaskets) {
            if (p != null) {
                summ = summ + p.getPrice();
            }
        }
        return summ;
    }

    public void printBascet() {
        int isSpecialCounter = 0;
        if (productBaskets.isEmpty()) {
            System.out.println("«В корзине пусто»");
            return;
        }
        for (Product product : productBaskets) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    isSpecialCounter++;
                }
            }
        }
        System.out.println("Итого: <общая стоимость корзины = " + generalPraisBascet() + " >");
        System.out.println("Специальных товаров: " + isSpecialCounter);

    }


    public boolean searchByNameProductInBasket(String nameProduct) {
        boolean searchName = false;
        for (Product product : productBaskets) {
            if (product != null && product.getNameProduct().equals(nameProduct)) {
                searchName = true;
            }
        }
        System.out.println("поиск по строке-" + nameProduct + ", результат = " + searchName);
        return searchName;
    }

    public void cleaningBascet() {
        productBaskets.clear();
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBaskets=" + productBaskets +
                '}';
    }
}



