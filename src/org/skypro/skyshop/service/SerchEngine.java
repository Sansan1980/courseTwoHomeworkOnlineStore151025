package org.skypro.skyshop.service;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.*;

public class SerchEngine {
    private Set<Searchable> setEngine;
    Set<Searchable> searchResult = new TreeSet<>(new Comparator<Searchable>() {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthCompare = Integer.valueOf(o2.searchTerm().length()) - Integer.valueOf(o1.searchTerm().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return o1.searchTerm().compareTo(o2.searchTerm());
        }
    });


    public SerchEngine() {
        this.setEngine = new HashSet<>();

    }


    public Set<Searchable> search(String substring) {

        if (!setEngine.isEmpty()) {
            for (Searchable element : setEngine) {
                if (element != null && element.searchTerm().contains(substring)) {
                    searchResult.add(element);
                }
            }
        } else {
            System.out.println(("Список setEngine - пустой"));
        }
        return searchResult;
    }

    public void add(Searchable value) {
        setEngine.add(value);
        System.out.println("SerchEngine.add - поисковое имя  продукта = " + value.searchTerm());
    }


    public Searchable maximumMatchCalculation(String search) throws BestResultNotFound {
        Searchable sear = null;
        int maxCount = 0;
        for (Searchable searchable : setEngine) {
            if (searchable != null) {
                String nameAndText = searchable.searchTerm();
                int nextCountNameAndText = countIndexProductName(nameAndText, search);
                if (nextCountNameAndText > maxCount) {
                    maxCount = nextCountNameAndText;
                    sear = searchable;
                }
            }

        }
        if (sear == null) {
            throw new BestResultNotFound("результат поиска, для запроса ( " + search + " ) = отсутствует. ");
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


    @Override
    public String toString() {
        return "SerchEngine{" +
                "setEngine=" + setEngine +
                '}';
    }


}

