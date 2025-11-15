package org.skypro.skyshop.service;

public class SerchEngine {
    private Searchable[] arr;
    private static int counterSearchEngine;

    public SerchEngine(int size) {
        this.arr = new Searchable[size];
    }

    public Searchable[] search(String s) {
        int counter = 0;
        Searchable[] searchResult = new Searchable[5];
        if (counter <= searchResult.length - 1) {
            for (Searchable value : arr) {
                if (value != null && counter <= searchResult.length - 1) {
                    String string = value.searchTerm();
                    if (string.contains(s)) {
                        searchResult[counter] = value;
                        counter++;
                    }
                }
            }
        }

        return searchResult;
    }

    public void add(Searchable value) {
        if (counterSearchEngine <= arr.length - 1) {
            arr[counterSearchEngine] = value;
            counterSearchEngine++;
            System.out.println(value);
        } else {
            System.out.println("SerchEngine.add - посиковый массив ,Searchable[] arr, переполнен нельзя дообавить продукт: - " + value);
        }
    }

    public Searchable searchPrecision(String search) {

    }

}
