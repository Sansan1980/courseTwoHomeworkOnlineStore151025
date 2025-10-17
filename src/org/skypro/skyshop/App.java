package org.skypro.skyshop;

import org.skypro.skyshop.bascet.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product hleb = new Product("Hleb", 2);
        Product stul = new Product(("Stul"), 6);
        Product apple = new Product("Apple", 3);
        Product tetrad = new Product("Tetrad", 7);
        Product orang = new Product("Orang", 1);
        Product lampa = new Product("Lampa", 2);
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
        Boolean b = productBasket.searchByNameProductInBasket("Nog");
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