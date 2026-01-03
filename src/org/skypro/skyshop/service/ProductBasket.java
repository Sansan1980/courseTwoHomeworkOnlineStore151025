package org.skypro.skyshop.service;

import org.skypro.skyshop.model.Product;

import java.util.*;

public class ProductBasket {
    //  private final List<Product> productBaskets;
    private final Map<String, List<Product>> productBasketsMap;
    // private int counterBascet;

    public ProductBasket() {
        this.productBasketsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        String key = creatingKeyTheBasketMap(product.getNameProduct());
        if (!productBasketsMap.containsKey(key)) {
            List<Product> productBasketsList = new ArrayList<>();
            productBasketsList.add(product);
            productBasketsMap.put(key, productBasketsList);
        }

        // counterBascet = counterBascet + 1;
    }

    public List<Product> deleteProductByName(String nameProduct) {
        List<Product> listDeleteProductByName = new ArrayList<>();
        if (!productBasketsMap.containsKey(creatingKeyTheBasketMap(nameProduct))) {
            System.out.println("По данному запросу - " + nameProduct + ", нет продуктов");
        } else {

        }


//        Iterator<Product> iterator = productBasketsMap.iterator();
//        while (iterator.hasNext()) {
//            Product element = iterator.next();
//            if (element.getNameProduct().equals(nameProduct)) {
//                System.out.println("ProductBasket.deleteProductByName " + element);
//                listDeleteProductByName.add(element);
//                iterator.remove();
//            }
//        }
//        if (listDeleteProductByName.isEmpty()) {
//            System.out.println("Список пуст");
//        }
//        return listDeleteProductByName;
    }


    public int generalPraisBascet() {
        int summ = 0;
        for (Product p : productBasketsMap) {
            if (p != null) {
                summ = summ + p.getPrice();
            }
        }
        return summ;
    }

    public void printBascet() {
        int isSpecialCounter = 0;
        if (productBasketsMap.isEmpty()) {
            System.out.println("«В корзине пусто»");
            return;
        }
        for (Product product : productBasketsMap) {
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
        for (Product product : productBasketsMap) {
            if (product != null && product.getNameProduct().equals(nameProduct)) {
                searchName = true;
            }
        }
        System.out.println("поиск по строке-" + nameProduct + ", результат = " + searchName);
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
        String keyTheBasketMap = name;
        return keyTheBasketMap;
    }
}
//Необходимо изменить структуру хранения данных в корзине на мап
// когда приходит проодукт в метод аддПродукт ()
//1.проверяепм что продукт не нулл и его имя не нулл
// 2.проверяем есть в мапе Лист с таким ключем или нет,
// если нет то создаем новый лист с этим ключем
// 3. Ложим этот лист в мапу.


