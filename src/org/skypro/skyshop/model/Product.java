package org.skypro.skyshop.model;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public abstract boolean isSpecial();

    public String getNameProduct() {
        return nameProduct;
    }


    public abstract int getPrice();

}





