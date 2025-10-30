package org.skypro.skyshop.model;

import org.skypro.skyshop.service.Searchable;

public class Article implements Searchable {
    //    название статьи в виде строки,
    private String nameArticle;

    //текст статьи в виде строки.
    private String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }

    //Метод получения search term (термина поиска) — метод,
// который будет возвращать текст, по которому мы будем искать.
    public String searchTerm() {
        return textArticle;
    }

    //Метод получения типа контента, который мы нашли.
// Метод должен возвращать строку с названием типа контента.
    public String returnsNameTipContent() {
        return "Article";
    }

    //Метод получения имени Searchable-объекта.

    public String getStringRepresentation() {// почему-то ошибка когда default
        return "Имя объекта - " + getNameArticle() +
                "Тип объекта - " + returnsNameTipContent();
    }
    //Добавьте в класс метод toString
    //, который будет преобразовывать статью в строку такого вида:
    //Название статьи
    //Текст статьи
    @Override
    public String toString() {
        return "Название статьи - " + getNameArticle() +
                ", Текст статьи - " + getTextArticle();
    }


}

