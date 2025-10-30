package org.skypro.skyshop.model;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discount;

    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        this.basicPrice = basicPrice;
        this.discount = discount;
    }


    public int getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(int basicPrice) {
        this.basicPrice = basicPrice;
    }

    public int getDiscount() {
        return discount;
    }


    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        int priceProduct = getBasicPrice() - ((getBasicPrice() / 100) * getDiscount());
        return priceProduct;
    }

    @Override
    public String toString() {
        return "Имя продукта со скидкой - " + getNameProduct() +
                " , Базовая цена - " + getBasicPrice() +
                " , Скидка - " + getDiscount() + "  процентов" +
                ", Стоимость продукта - " + getPrice();
    }
    @Override
    public String searchTerm() {
        return getNameProduct();
    }

    @Override
    public String returnsNameTipContent() {
        return "DISCOUNT_PRODUCT";
    }

    @Override
    public String getStringRepresentation() {// почему-то ошибка когда default
        return "Имя объекта - " + getNameProduct() +
                ", Тип объекта - " + returnsNameTipContent();
    }
}
