package org.skypro.skyshop.main;

import org.skypro.skyshop.exeption.BestResultNotFound;
import org.skypro.skyshop.exeption.IllegalDiscountPriceArgumentException;
import org.skypro.skyshop.exeption.IllegalProductNameArgumentException;
import org.skypro.skyshop.exeption.IllegalSimpleProductPriceArgumentException;
import org.skypro.skyshop.model.*;
import org.skypro.skyshop.service.ProductBasket;
import org.skypro.skyshop.service.Searchable;
import org.skypro.skyshop.service.SerchEngine;

import java.io.IOException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        SerchEngine serchEngine = new SerchEngine(7);

        System.out.println("Создаем продукты");
        System.out.println("++++++++++++++");
        Searchable articleHleb = new Article("Описание товара", "хлеб ручной работы");
        Article articleStul = new Article("Описание товара", "стул деревянный");
        Product tetrad = new FixPriceProduct("тетрадь");
        Product lampa = new SimpleProduct("лампа", 969);
        Product stol = new SimpleProduct("стул", 159);
        Product lampa2 = new SimpleProduct("лампа", 23);
        Product stol2 = new SimpleProduct("стул", 159);
        Product lampa3 = new SimpleProduct("лампа", 45);
        Product stol3 = new SimpleProduct("стул", 159);
        Product lampa4 = new SimpleProduct("лампа", 567);
        Product stol4 = new SimpleProduct("стул", 159);
        Product lampa5 = new SimpleProduct("лампа", 3);
        Product stol5 = new SimpleProduct("стул", 159);
        Article articleStol = new Article("Описание товара", "стол деревянный");
        Product blocknot = new FixPriceProduct("блокнот");
        Product bra = new SimpleProduct("бра", 100);

        System.out.println("+++++++++++++++++++++");

        System.out.println("создаем продукты с ошибкой-----------");
        try {
            Product orang = new SimpleProduct("", 1);
            productBasket.addProduct(orang);
            serchEngine.add(orang);
        } catch (IllegalProductNameArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalProductNameArgumentException");
        }
        try {
            Product hleb = new SimpleProduct(("хлеб"), 0);
            productBasket.addProduct(hleb);
            serchEngine.add(hleb);
        } catch (IllegalSimpleProductPriceArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalSimpleProductPriceArgumentException");
        }
        try {
            Product stul = new DiscountedProduct(("стул"), 6000, 101);
            productBasket.addProduct(stul);
            serchEngine.add(stul);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalDiscountPriceArgumentException");
        }
        try {
            Product apple = new DiscountedProduct("Apple", 0, 12);
            productBasket.addProduct(apple);
            serchEngine.add(apple);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("IllegalDiscountPriceArgumentException");
        }
        System.out.println("------------------------------");



        System.out.println("///////");

        System.out.println("ложим продукты в корзину");
        productBasket.addProduct(tetrad);
        productBasket.addProduct(lampa);
        productBasket.addProduct(stol);
        productBasket.addProduct(lampa2);
        productBasket.addProduct(stol2);
        productBasket.addProduct(lampa3);
        productBasket.addProduct(stol3);
        productBasket.addProduct(lampa4);
        productBasket.addProduct(stol4);
        productBasket.addProduct(lampa5);
        productBasket.addProduct(stol5);
        productBasket.addProduct(blocknot);
        productBasket.addProduct(bra);
        System.out.println("/-/-/-/-");

        System.out.println("Заполгнение поисковой корзины");
        serchEngine.add(articleHleb);
        serchEngine.add(articleStul);
        serchEngine.add(articleStol);
        serchEngine.add(tetrad);
        serchEngine.add(lampa);
        serchEngine.add(bra);
        serchEngine.add(stol);
        serchEngine.add(blocknot);
        System.out.println("--------");


        System.out.println("productBasket.printBascet");
        productBasket.printBascet();

        System.out.println();
        Integer generalPraisBascet = productBasket.generalPraisBascet();
        System.out.println("generalPraisBascet = " + generalPraisBascet);
        System.out.println();
        Boolean searchByNameProductInBasket = productBasket.searchByNameProductInBasket("тетрадь");
        System.out.println("searchByNameProductInBasket = " + searchByNameProductInBasket);
        System.out.println();
        productBasket.cleaningBascet();
        System.out.println("cleaningBascet");
        System.out.println();

        System.out.println("productBascet=" + productBasket);
        System.out.println("+++++++++++++____________");
        productBasket.printBascet();
        System.out.println("+++++++++++++____________");
        generalPraisBascet = productBasket.generalPraisBascet();
        System.out.println("generalPraisBascet = " + generalPraisBascet);
        System.out.println();
        searchByNameProductInBasket = productBasket.searchByNameProductInBasket("тетрадь");
        System.out.println("searchByNameProductInBasket = " + searchByNameProductInBasket);


        System.out.println();
        Searchable[] search = serchEngine.search("сани");
        System.out.println("search = " + Arrays.toString(search));
        try {
            Searchable searchable = serchEngine.maximumMatchCalculation("сани");
            System.out.println("searchable = " + searchable);
        } catch (BestResultNotFound exception) {
            exception.printStackTrace();
        }
        try {
            serchEngine.maximumMatchCalculation("sss");
        } catch (BestResultNotFound exception) {
            exception.printStackTrace();
        }

        System.out.println("00000000000000000");

        productBasket.addProduct(tetrad);
        productBasket.addProduct(lampa);
        productBasket.addProduct(stol);
        productBasket.addProduct(lampa2);
        productBasket.addProduct(stol2);
        productBasket.addProduct(lampa3);
        productBasket.addProduct(stol3);
        productBasket.addProduct(lampa4);
        productBasket.addProduct(stol4);
        productBasket.addProduct(lampa5);
        productBasket.addProduct(stol5);
        productBasket.addProduct(blocknot);
        productBasket.addProduct(bra);
        productBasket.printBascet();
        productBasket.deleteProduct("лампа");
        productBasket.printBascet();


    }
}