package org.skypro.skyshop.main;

import org.skypro.skyshop.bascet.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product hleb = new SimpleProduct("Hleb", 2);
        Product stul = new DiscountedProduct(("Stul"), 6000,50);
        Product apple = new FixPriceProduct("Apple");
        Product tetrad = new FixPriceProduct("Tetrad");
        Product orang = new SimpleProduct("Orang", 1);
        Product lampa = new SimpleProduct("Lampa", 2);
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
        Boolean b = productBasket.searchByNameProductInBasket("Tetrad");
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