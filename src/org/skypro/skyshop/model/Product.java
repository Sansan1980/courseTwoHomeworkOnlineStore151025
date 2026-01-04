package org.skypro.skyshop.model;

import org.skypro.skyshop.exeption.IllegalProductNameArgumentException;
import org.skypro.skyshop.service.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) throws IllegalProductNameArgumentException{
       chekNameProduct(nameProduct);
        this.nameProduct = nameProduct;

    }

    public abstract boolean isSpecial();

    public String getNameProduct() {
        return nameProduct;
    }

    public String searchTerm() {
        return getNameProduct() + "PRODUCT";
    }


    public abstract int getPrice();

    public void chekNameProduct(String nameProduct) throws IllegalProductNameArgumentException{
            if (nameProduct.isBlank() || nameProduct == null) {
                throw new IllegalProductNameArgumentException("Введенное имя isBlank или null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct);
    }
}





