package org.skypro.skyshop.exeption;

public class IllegalBasicPriceArgumentException extends IllegalArgumentException {

    public  IllegalBasicPriceArgumentException(String message) {
        super(message);
    }
// реализуйте проверки базовой цены и процента скидки. Правила для базовой
// цены — такие же, как для цены в классе
//SimpleProduct
//    //. Правила для процента скидки — процент должен быть числом в диапазоне от
//// 0 до 100 включительно. Слово «включительно» означает, что границы диапазона
////  0 и 100 тоже являются правильными значениями.
////Проверки по этим условиям нужно добавить в конструкторы классов. Если условия
////не выполняются, вам нужно выбросить
////IllegalArgumentException
//// с сообщением, в котором раскрыты детали о том, какое правило не сработало.


}
