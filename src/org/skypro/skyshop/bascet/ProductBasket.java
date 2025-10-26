package org.skypro.skyshop.bascet;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class ProductBasket {
    private Product[] productBaskets = new Product[5];
    public static int counter = 0;
    public static int isSpecialCounter = 0;

    public void addProduct(Product product) {
        if (counter < 5) {
            productBaskets[counter] = product;
            counter = counter + 1;

        } else {
            System.out.println("«Невозможно добавить " + product + " , корзина полна ».");
        }
    }

    public Integer generalPraisBascet() {
        Integer summ = 0;
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
        return v;
    }

    public void cleaningBascet() {
        for (int i = 0; i < productBaskets.length; i++) {
            productBaskets[i] = null;
        }
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBaskets=" + Arrays.toString(productBaskets) +
                '}';
    }
}



