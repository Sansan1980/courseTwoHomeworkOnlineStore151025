package org.skypro.skyshop.service;

import org.skypro.skyshop.model.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> productBaskets = new LinkedList<>();
    public static int counterBascet = 0;
    public static int isSpecialCounter = 0;
    private List<Product> listDeleteProductByName = new LinkedList<>();

    public void addProduct(Product product) {

        productBaskets.add(product);
        counterBascet++;
//        System.out.println("ProductBasket.addProduct: " + product);
//        System.out.println("");

    }

    public List<Product> deleteProductByName(String nameProduct) {
        listDeleteProductByName.clear();
        System.out.println("Список listDeleteProductByName - Очищен от старого запроса");
        System.out.println(listDeleteProductByName);
        Iterator<Product> iterator = productBaskets.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getNameProduct().equals(nameProduct)) {
                System.out.println("ProductBasket.deleteProductByName " + element);
                listDeleteProductByName.add(element);
                iterator.remove();
            }
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
                    if (product.isSpecial()) {
                        isSpecialCounter++;
                    }
                    System.out.println(product);
                }
            }
        } else {
            System.out.println("«В корзине пусто»");
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
            productBaskets.clear();
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



