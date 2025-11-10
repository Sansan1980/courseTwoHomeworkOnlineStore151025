package org.skypro.skyshop.model;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
        try {
            if (nameProduct.isBlank() || nameProduct == null) {
                throw new RuntimeException();
            }
        } catch (RuntimeException exception) {
            System.out.println("nameProduct =  " + "'" + nameProduct + "'" + " -Введена пустая строка или содержит null");
        }
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

}





