package org.skypro.skyshop.model;

public class SimpleProduct  extends Product {
    private Integer praisProduct;

    public SimpleProduct(String name, Integer praisProduct) {
        super(name);
        this.praisProduct = praisProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public Integer getPrice() {
        return praisProduct;
    }

    @Override
    public String toString() {
        return "Имя продукта - " + getNameProduct() +
                "Его стоимость - " + getPrice();
    }
}
