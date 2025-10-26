package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final Integer FIX_PRICE_PRODUCT = 50; // эх были времена!;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public Integer getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        //имя продукта c фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
        return "Имя продукта c фиксированной ценой : " + getNameProduct() +
                "Фиксированная цена - " + getPrice();
    }
}
