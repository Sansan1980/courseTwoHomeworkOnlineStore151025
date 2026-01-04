package org.skypro.skyshop.main;

import org.skypro.skyshop.exeption.BestResultNotFound;
import org.skypro.skyshop.exeption.IllegalProductNameArgumentException;
import org.skypro.skyshop.exeption.IllegalSimpleProductPriceArgumentException;
import org.skypro.skyshop.model.*;
import org.skypro.skyshop.service.ProductBasket;
import org.skypro.skyshop.service.Searchable;
import org.skypro.skyshop.service.SerchEngine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        SerchEngine serchEngine = new SerchEngine();

        System.out.println("Создаем продукты");
        System.out.println("++++++++++++++");
        Searchable articleHleb = new Article("Описание товара", "хлеб ручной работы");
        Article articleStul = new Article("Описание товара", "стул деревянный");
        Product tetrad = new FixPriceProduct("тетрадь");
        Product lampa = new SimpleProduct("лампа", 969);
        Product stul = new SimpleProduct("стул", 159);
        Product lampa2 = new SimpleProduct("лампа", 23);
        Product stul2 = new SimpleProduct("стул", 159);
        Product lampa3 = new SimpleProduct("лампа", 45);
        Product stul3 = new SimpleProduct("стул", 159);
        Product lampa4 = new SimpleProduct("лампа", 567);
        Product stul4 = new SimpleProduct("стул", 159);
        Product lampa5 = new SimpleProduct("лампа", 3);
        Product stul5 = new SimpleProduct("стул", 159);
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
            stul = new DiscountedProduct(("стул"), 6000, 101);
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
        productBasket.addProduct(stul);
        productBasket.addProduct(lampa2);
        productBasket.addProduct(stul2);
        productBasket.addProduct(lampa3);
        productBasket.addProduct(stul3);
        productBasket.addProduct(lampa4);
        productBasket.addProduct(stul4);
        productBasket.addProduct(lampa5);
        productBasket.addProduct(stul5);
        productBasket.addProduct(blocknot);
        productBasket.addProduct(bra);


        System.out.println("/-/-/-/-");

        System.out.println("Заполгнение поисковой корзины");
        serchEngine.add(articleHleb);
        serchEngine.add(articleStul);
        serchEngine.add(articleStol);
        serchEngine.add(tetrad);
        serchEngine.add(lampa);
        serchEngine.add(stul);
        serchEngine.add(lampa2);
        serchEngine.add(stul2);
        serchEngine.add(lampa3);
        serchEngine.add(stul3);
        serchEngine.add(lampa4);
        serchEngine.add(stul4);
        serchEngine.add(lampa5);
        serchEngine.add(stul5);
        serchEngine.add(bra);
        serchEngine.add(blocknot);
        System.out.println("--------");
        System.out.println("+++++++++++++++++++");

        System.out.println(serchEngine);

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
        Map<String,Searchable> search = serchEngine.search("стул");
        System.out.println("search = " + search);
        try {
            Searchable searchable = serchEngine.maximumMatchCalculation("л");
            System.out.println("searchable = " + searchable);
        } catch (BestResultNotFound exception) {
            exception.printStackTrace();
        }
        try {
            Searchable searchable = serchEngine.maximumMatchCalculation("sss");
            System.out.println("searchable = " + searchable);
        } catch (BestResultNotFound exception) {
            exception.printStackTrace();
        }

        System.out.println("00000000000000000");

        productBasket.addProduct(tetrad);
        productBasket.addProduct(lampa);
        productBasket.addProduct(stul);
        productBasket.addProduct(lampa2);
        productBasket.addProduct(stul2);
        productBasket.addProduct(lampa3);
        productBasket.addProduct(stul3);
        productBasket.addProduct(lampa4);
        productBasket.addProduct(stul4);
        productBasket.addProduct(lampa5);
        productBasket.addProduct(stul5);
        productBasket.addProduct(blocknot);
        productBasket.addProduct(bra);
        productBasket.printBascet();

        System.out.println();
        System.out.println("Список  удаленных товаров");
        List<Product> deleteProductByName = productBasket.deleteProductByName("лампа");
        System.out.println(deleteProductByName);
        productBasket.printBascet();



    }
}