package org.skypro.skyshop.service;

import org.skypro.skyshop.model.Product;

import java.util.*;

public class ProductBasket {
    private final List<Product> productBaskets;
    public static int counterBascet = 0;
    public static int isSpecialCounter = 0;

    public ProductBasket() {
        this.productBaskets = new LinkedList<>();
    }

    public void addProduct(Product product) {

        productBaskets.add(product);
        counterBascet++;
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
        if (!productBaskets.isEmpty()) {
            for (Product product : productBaskets) {
                if (product != null) {
                    System.out.println(product);
                    isSpecialCounter = (product.isSpecial()) ? isSpecialCounter + 1 : isSpecialCounter;
                } else {
                    System.out.println("«В корзине пусто»");
                }
            }
                System.out.println("Итого: <общая стоимость корзины = " + generalPraisBascet() + " >");
                System.out.println("Специальных товаров: " + isSpecialCounter);
        }
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
        productBaskets.clear();
        isSpecialCounter = 0;
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBaskets=" + productBaskets.toString() +
                '}';
    }
}



