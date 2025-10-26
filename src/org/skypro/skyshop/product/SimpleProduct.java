package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private Integer praisProduct;

    public SimpleProduct(String name, Integer praisProduct) {
        super(name);
        this.praisProduct = praisProduct;
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
