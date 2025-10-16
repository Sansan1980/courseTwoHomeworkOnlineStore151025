package org.skypro.skyshop.bascet;

import org.skypro.skyshop.product.Product;

import java.sql.Array;

public class ProductBasket {
    private Product[] productBaskets = new Product[5];
    public static int counter = 0;

    //    Метод добавления продукта в корзину: метод принимает в себя
//    продукт и ничего не возвращает.
    public void addProduct(Product product) {
        if (counter <= 5) {
            productBaskets[counter] = product;
            counter = counter + 1;

        } else {
            System.out.println("«Невозможно добавить продукт , корзина полна ».");
        }
    }

    //    Метод получения общей стоимости корзины: метод ничего не
//    принимает и возвращает целое число.
    public Integer generalPraisBascet() {
        Integer summ = 0;
        for (Product p : productBaskets) {
            summ = summ + p.getPriceProduct();
        }
        return summ;
    }


//  3.          Метод, который печатает содержимое корзины: метод ничего
//    не принимает и не возвращает, но печатает в консоль сообщение
//    вида:
//<имя продукта>: <стоимость>
//<имя продукта>: <стоимость>
//<имя продукта>: <стоимость>
//    Итого: <общая стоимость корзины>
//    Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».

    public void printBascet() {
        for (Product product : productBaskets) {
            int a = 0;
            if (product == null) {
                a = a + 1;
                if (a == 5) {
                    System.out.println("«в корзине пусто»");
                }
            } else {
                System.out.println(product);
            }
        }
        System.out.println("Итого: <общая стоимость корзины = " + generalPraisBascet());
    }


    //  4.  Метод, проверяющий продукт в корзине по имени: метод принимает в
//    себя строку имени и возвращает boolean  в зависимости от того, есть продукт в корзине или его нет.
    public Boolean searchByNameProductInBasket(String nameProduct) {
        boolean v = false;
        for (Product product : productBaskets) {
            if (product.getNameProduct().equals(nameProduct)) {
                v = true;
            }
        }
        return v;
    }
//   5. Метод очистки корзины: метод ничего не принимает и очищает массив,
//    проставляя всем его элементам null

    public void cleaningBascet() {
        for (Product product : productBaskets) {
            product = null;
        }
    }
}



//            .
//    Обратите внимание!
//
//    В качестве хранилища для объектов product используйте
//    массив из пяти элементов, однако прямой доступ
//    к этому массиву должен быть невозможен.
//
//    Если в массиве не хватает места на следующий продукт,
//    то метод добавления продукта должен выводить в консоль
//    сообщение вида: «Невозможно добавить продукт».
//}

