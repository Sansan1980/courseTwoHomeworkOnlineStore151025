package org.skypro.skyshop.main;

import org.skypro.skyshop.model.*;
import org.skypro.skyshop.service.ProductBasket;
import org.skypro.skyshop.service.Searchable;
import org.skypro.skyshop.service.SerchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Searchable articleHleb = new Article("Описание товара", "хлеб ручной работы");
        Article articleStul = new Article("Описание товара", "стул деревянный");
        Product hleb = new SimpleProduct(("хлеб"), 50);
        Product stul = new DiscountedProduct(("стул"), 6000, 50);
        Product apple = new FixPriceProduct("Apple");
        Product tetrad = new FixPriceProduct("тетрадь");
        Product orang = new SimpleProduct("апельсин", 1);
        Product lampa = new SimpleProduct("лампа", 2);

        SerchEngine serchEngine = new SerchEngine(7);
        serchEngine.add(articleHleb);
        serchEngine.add(articleStul);
        serchEngine.add(hleb);
        serchEngine.add(stul);
        serchEngine.add(apple);
        serchEngine.add(tetrad);
        serchEngine.add(orang);
        serchEngine.add(lampa);

        Searchable[] search = serchEngine.search("ь");
        System.out.println(Arrays.toString(search));

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(hleb);
        productBasket.addProduct(stul);
        productBasket.addProduct(apple);
        productBasket.addProduct(tetrad);
        productBasket.addProduct(orang);
        productBasket.addProduct(lampa);

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
        b = productBasket.searchByNameProductInBasket("Nog");
        System.out.println(b);

    }
}