package org.skypro.skyshop.service;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;

public class SerchEngine {
    private List<Searchable> listEngine ;

    public SerchEngine() {
        this.listEngine = new LinkedList<>();
    }

    public List<Searchable> search(String substring) {
        List<Searchable> searchResult = new LinkedList<>();
            for (Searchable element : listEngine) {
                if (element != null) {
                    String string = element.searchTerm();
                    if (string.contains(substring)) {
                        searchResult.add(element);
                    }
                }
            }

        return searchResult;
    }

    public void add(Searchable value) {
            listEngine.add(value);
            System.out.println("SerchEngine.add - " +  value);
        }


    public Searchable maximumMatchCalculation(String search) throws BestResultNotFound {
        Searchable sear = null;
        int maxCount = 0;
        for (Searchable object : listEngine) {
            if (object != null) {
                String nameAndText = object.searchTerm();
                int nextCountNameAndText = countIndexProductName(nameAndText, search);
                if (nextCountNameAndText > maxCount) {
                    maxCount = nextCountNameAndText;
                    sear = object;
                }
            }

        }
        if (sear == null) {
            throw new BestResultNotFound("результат поиска для строки search ( " + search + " ) = null");
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

