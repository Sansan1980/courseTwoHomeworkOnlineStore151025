package org.skypro.skyshop.service;

import org.skypro.skyshop.exeption.BestResultNotFound;

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
            System.out.println("SerchEngine.add");
            System.out.println(value);
        } else {
            System.out.println("SerchEngine.add - посиковый массив ,Searchable[] arr, переполнен нельзя дообавить продукт: - " + value);
        }
    }

    public Searchable maximumMatchCalculation(String search) throws BestResultNotFound {
        Searchable sear = null;
        int maxCount = 0;
        for (Searchable object : arr) {
            if (object != null) {
                String nameAndText = object.searchTerm();
                int nextCountNameAndText = countIndexProductName(nameAndText, search);
                if (nextCountNameAndText > maxCount) {
                    maxCount = nextCountNameAndText;
                    sear = object;
                }
            }
            if (sear == null) {

                throw new BestResultNotFound("результат поиска для строки = null");
            }

        }
        return sear;
    }

    private int countIndexProductName(String nameAndText, String search) {
        int count = 0;
        int index = 0;
        while ((index = nameAndText.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }
}

