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
        String query = "example";


        Searchable articleHleb = new Article("Описание товара", "хлеб ручной работы");
        Article articleStul = new Article("Описание товара", "стул деревянный");
        Product tetrad = new FixPriceProduct("тетрадь");
        Product lampa = new SimpleProduct("лампа", 969);
        Product stol = new SimpleProduct("стул", 159);

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
        Article articleStol = new Article("Описание товара", "стол деревянный");
        Product blocknot = new FixPriceProduct("блокнот");
        Product bra = new SimpleProduct("бра", 100);


        System.out.println("///////");


        productBasket.addProduct(tetrad);
        productBasket.addProduct(lampa);
        productBasket.addProduct(stol);
        productBasket.addProduct(blocknot);
        productBasket.addProduct(bra);
        System.out.println("/-/-/-/-");

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

        Integer generalPraisBascet = productBasket.generalPraisBascet();
        System.out.println("generalPraisBascet = " + generalPraisBascet);
        Boolean searchByNameProductInBasket = productBasket.searchByNameProductInBasket("тетрадь");
        System.out.println("searchByNameProductInBasket = " + searchByNameProductInBasket);
        productBasket.cleaningBascet();
        System.out.println("cleaningBascet");

        System.out.println("productBascet=" + productBasket);
        productBasket.printBascet();
        generalPraisBascet = productBasket.generalPraisBascet();
        System.out.println("generalPraisBascet = " + generalPraisBascet);
        searchByNameProductInBasket = productBasket.searchByNameProductInBasket("тетрадь");
        System.out.println("searchByNameProductInBasket = " + searchByNameProductInBasket);


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


    }
}