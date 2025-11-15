package org.skypro.skyshop.model;

import org.skypro.skyshop.exeption.IllegalBasicPriceArgumentException;
import org.skypro.skyshop.exeption.IllegalDiscountPriceArgumentException;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discount;


    public DiscountedProduct(String name, int basicPrice, int discount) throws IllegalBasicPriceArgumentException ,IllegalDiscountPriceArgumentException {
        super(name);
        chekDiscountedProductPrice(basicPrice, discount);
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
    public String returnsNameTipContent() {
        return "DISCOUNT_PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return "Имя объекта - " + getNameProduct() +
                ", Тип объекта - " + returnsNameTipContent();
    }

    public void chekDiscountedProductPrice(int basicPrice, int discount) throws IllegalBasicPriceArgumentException ,IllegalDiscountPriceArgumentException{
        if (basicPrice <= 0) {
            throw new IllegalBasicPriceArgumentException("Базовая цена указана неверно(меньше или равно нуль) ");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalDiscountPriceArgumentException("Дисконтная цена указана неверно (процент должен быть числом в диапазоне от\n" +
                    "    0 до 100 включительно ");
        }


    }
}

