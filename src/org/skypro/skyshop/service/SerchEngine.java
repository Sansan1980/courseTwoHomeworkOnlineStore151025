package org.skypro.skyshop.service;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.*;

public class SerchEngine {
    private Set<Searchable> setEngine;
    private int counter;


    public SerchEngine() {
        this.setEngine = new HashSet<>();

    }

    public Map<String, Searchable> search(String substring) {
        Map<String, Searchable> searchResult = new TreeMap();
        if (!setEngine.isEmpty()) {
            for (Searchable element : setEngine) {
                if (element != null && element.searchTerm().equals(substring)) {
                    searchResult.put(substring, element);
                }
            }
        } else {
            System.out.println(("Список mapEngine - пустой"));
        }
        return searchResult;
    }

    public void add(Searchable value) {
//        Searchable key = createKeySearchEngine(value);
        setEngine.add(value);
        System.out.println("SerchEngine.add - поисковое имя  продукта = " + value.searchTerm());
    }


    public Searchable maximumMatchCalculation(String search) throws BestResultNotFound {
        Searchable sear = null;
        int maxCount = 0;
        for (Searchable object : setEngine) {
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

//    public String createKeySearchEngine(Searchable value) {
//        //counter++;
//        String key = value.searchTerm()  /*+ counter*/;
//        return key;
//    }

    @Override
    public String toString() {
        return "SerchEngine{" +
                "mapEngine=" + setEngine +
                '}';
    }

    //    2. Модификация возвращаемого значения в методе поиска
//    В классе поискового движка вам нужно модифицировать метод
//    поиска таким образом, чтобы он возвращал отсортированную по именам мапу:
//
//    с ключом — именем
//            Searchable
//-объекта
//    и значением — самим
//            Searchable
//-объектом.
//    После этого перепишите код в методе
//    main
//, который работает с выводом результатов поиска.
}

