package org.skypro.skyshop.model;

public class SimpleProduct extends Product {
    private int praisProduct;

    public SimpleProduct(String name, int praisProduct) {
        super(name);
        this.praisProduct = praisProduct;
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
    public String searchTerm() {
        return getNameProduct();
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

}
