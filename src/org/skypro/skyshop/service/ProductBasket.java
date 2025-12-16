package org.skypro.skyshop.service;

import org.skypro.skyshop.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> productBaskets = new LinkedList<>();
    public static int counterBascet = 0;
    public static int isSpecialCounter = 0;

    public void addProduct(Product product) {

        productBaskets.add(product);
            counterBascet++;
            System.out.println("ProductBasket.addProduct: " + product);
            System.out.println("");

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
        int a = 0;
        for (Product product : productBaskets) {

            if (product != null) {
                if (product.isSpecial() != false) {
                    isSpecialCounter++;
                }

                System.out.println(product);
            } else {
                a = a + 1;
                if (a == 5) {
                    System.out.println("«в корзине пусто»");
                }
            }
        }
        System.out.println("Итого: <общая стоимость корзины = " + generalPraisBascet() + " >");
        System.out.println("Специальных товаров: " + isSpecialCounter);
    }

    public Boolean searchByNameProductInBasket(String nameProduct) {
        boolean v = false;
        for (Product product : productBaskets) {
            if (product != null && product.getNameProduct().equals(nameProduct)) {
                v = true;
            }
        }
        System.out.println("поиск по строке-" + nameProduct + ", результат = " + v);
        return v;
    }

    public void cleaningBascet() {
        for (int i = 0; i < productBaskets.size(); i++) {
            productBaskets.remove(1) ;
            isSpecialCounter = 0;
        }
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBaskets=" + productBaskets.toString() +
                '}';
    }
}



