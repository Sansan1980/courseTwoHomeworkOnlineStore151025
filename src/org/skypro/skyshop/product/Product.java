package org.skypro.skyshop.product;

public class Product {
    private final String nameProduct;
    private final Integer priceProduct;

    public Product(String nameProduct, Integer priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Integer getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
