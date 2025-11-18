package org.skypro.skyshop.main;

import org.skypro.skyshop.exeption.IllegalDiscountPriceArgumentException;
import org.skypro.skyshop.exeption.IllegalProductNameArgumentException;
import org.skypro.skyshop.exeption.IllegalSimpleProductPriceArgumentException;
import org.skypro.skyshop.model.*;
import org.skypro.skyshop.service.ProductBasket;
import org.skypro.skyshop.service.Searchable;
import org.skypro.skyshop.service.SerchEngine;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        SerchEngine serchEngine = new SerchEngine(7);

        Searchable articleHleb = new Article("Описание товара", "хлеб ручной работы");
        Article articleStul = new Article("Описание товара", "стул деревянный");
        Product tetrad = new FixPriceProduct("тетрадь");
        Product lampa = new SimpleProduct("лампа", 969);

        try {
            Product orang = new SimpleProduct("", 1);
            serchEngine.add(orang);
            productBasket.addProduct(orang);
        } catch (IllegalProductNameArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalProductNameArgumentException");
        }
        try {
            Product hleb = new SimpleProduct(("хлеб"), 0);
            serchEngine.add(hleb);
            productBasket.addProduct(hleb);
        } catch (IllegalSimpleProductPriceArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalSimpleProductPriceArgumentException");
        }
        try {
            Product stul = new DiscountedProduct(("стул"), 6000, 101);
            serchEngine.add(stul);
            productBasket.addProduct(stul);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalDiscountPriceArgumentException");
        }
        try {
            Product apple = new DiscountedProduct("Apple", 0, 12);
            serchEngine.add(apple);
            productBasket.addProduct(apple);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalDiscountPriceArgumentException");
        }


        System.out.println("///////");

        serchEngine.add(articleHleb);
        serchEngine.add(articleStul);
        serchEngine.add(tetrad);
        serchEngine.add(lampa);
        // serchEngine.add(stul);
//        serchEngine.add(apple);
//        serchEngine.add(orang);
        //   serchEngine.add(hleb);

        Searchable[] search = serchEngine.search("сани");
        System.out.println(Arrays.toString(search));

        productBasket.addProduct(tetrad);
        productBasket.addProduct(lampa);
//        productBasket.addProduct(stul);
//        productBasket.addProduct(apple);
//        productBasket.addProduct(orang);
        //  productBasket.addProduct(hleb);


        productBasket.printBascet();
        Integer v = productBasket.generalPraisBascet();
        System.out.println(v);
        Boolean b = productBasket.searchByNameProductInBasket("тетрадь");
        System.out.println(b);
        productBasket.cleaningBascet();
        System.out.println(productBasket);

        productBasket.printBascet();
        v = productBasket.generalPraisBascet();
        System.out.println(v);
        b = productBasket.searchByNameProductInBasket("тетрадь");
        System.out.println(b);

    }
}