package org.skypro.skyshop.model;

import org.skypro.skyshop.exeption.IllegalProductNameArgumentException;
import org.skypro.skyshop.exeption.IllegalSimpleProductPriceArgumentException;

public class SimpleProduct extends Product {
    private int praisProduct;

    public SimpleProduct(String name, int priceProduct) throws IllegalSimpleProductPriceArgumentException{
        super(name);
        checSimpleProductPrice(priceProduct);
        this.praisProduct = priceProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return praisProduct;
    }

    @Override
    public String toString() {
        return "Имя продукта - " + getNameProduct() +
                ", Его стоимость - " + getPrice();
    }


    @Override
    public String returnsNameTipContent() {
        return "SIMPLE_PRODUCT";
    }

    @Override
    public String getStringRepresentation() {// почему-то ошибка когда default
        return "Имя объекта - " + getNameProduct() +
                "Тип объекта - " + returnsNameTipContent();
    }

    public void checSimpleProductPrice(int priceProduct) throws IllegalSimpleProductPriceArgumentException {
            if (priceProduct <= 0) {
                throw new IllegalSimpleProductPriceArgumentException("Цена продукта неверна, цена должна быть строго больше ноля. ");
            }
    }
}
