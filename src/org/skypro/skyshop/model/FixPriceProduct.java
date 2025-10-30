package org.skypro.skyshop.model;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE_PRODUCT = 50; // эх были времена!;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        //имя продукта c фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
        return "Имя продукта c фиксированной ценой : " + getNameProduct() +
                ", Фиксированная цена - " + getPrice();
    }
    @Override
    public String searchTerm() {
        return getNameProduct();
    }

    @Override
    public String returnsNameTipContent() {
        return "FIX_PRICE_PRODUCT";
    }

    @Override
    public String getStringRepresentation() {// почему-то ошибка когда default
        return "Имя объекта - " + getNameProduct() +
                ", Тип объекта - " + returnsNameTipContent();
    }
}
