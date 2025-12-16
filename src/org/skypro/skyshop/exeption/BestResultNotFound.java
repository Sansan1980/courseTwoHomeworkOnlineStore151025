package org.skypro.skyshop.exeption;

public class BestResultNotFound extends Exception {


    public BestResultNotFound(String message) {
        super(message);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message,cause);
    }
//4.  Добавление исключений
//    Мы не хотим, чтобы метод поиска наиболее подходящего объекта возвращал
//    null
//    , если такого объекта нет. Поэтому если объект не найден, вам нужно выбрасывать
//    собственное исключение — назовите его
//    BestResultNotFound
//    Это исключение должно быть проверяемым, и в сообщении должно содержать
//    информацию, для какого поискового запроса не нашлось подходящей статьи.
}
