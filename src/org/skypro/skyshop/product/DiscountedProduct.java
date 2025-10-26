package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private Integer basicPrice;
    private Integer discount;

    public DiscountedProduct(String name, Integer basicPrice, Integer discount) {
        super(name);
        this.basicPrice = basicPrice;
        this.discount = discount;
    }


    public Integer getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Integer basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscountPrice(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public Integer getPrice() {
        Integer priceProduct = getBasicPrice() - ((getBasicPrice() / 100) * getDiscount());
        return priceProduct;
    }

    @Override
    public String toString() {
        return "Имя продукта со скидкой - " + getNameProduct() +
                " , Базовая цена - " + getBasicPrice() +
                " , Скидка - " + getDiscount() + "  процентов" +
                " Стоимость продукта - " + getPrice();
    }
}
