package org.skypro.skyshop.model;

import org.skypro.skyshop.exeption.IllegalProductNameArgumentException;
import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) throws IllegalArgumentException{
        chekNameProduct(nameProduct);
        this.nameProduct = nameProduct;

    }

    public abstract boolean isSpecial();

    public String getNameProduct() {
        return nameProduct;
    }

    public String searchTerm() {
        return getNameProduct() + " PRODUCT";
    }


    public abstract int getPrice();

    public void chekNameProduct(String nameProduct) throws IllegalArgumentException{
            if (nameProduct.isBlank() || nameProduct == null) {
                throw new IllegalProductNameArgumentException("Введенное имя isBlank или null");
        }
    }

}





