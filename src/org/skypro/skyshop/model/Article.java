package org.skypro.skyshop.model;

import org.skypro.skyshop.service.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String nameArticle;

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

    @Override
    public String searchTerm() {
        return getNameArticle()+getTextArticle();
    }

    @Override
    public String returnsNameTipContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {// почему-то ошибка когда default
        return "Имя объекта - " + getNameArticle() +
                ", Тип объекта - " + returnsNameTipContent();
    }

    @Override
    public String toString() {
        return "Название статьи - " + getNameArticle() +
                ", Текст статьи - " + getTextArticle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArticle);
    }
}

