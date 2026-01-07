package org.skypro.skyshop.service;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SerchEngine {
    private Set<Searchable> setEngine;

    public SerchEngine() {
        this.setEngine = new HashSet<>();

    }


    public TreeSet<Searchable> search(String substring) {
        TreeSet<Searchable> sortedSetEngine = setEngine.stream()
                .filter(((searchable) -> searchable.searchTerm().contains(substring)))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Searchable::searchTerm))));
        return sortedSetEngine;
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

