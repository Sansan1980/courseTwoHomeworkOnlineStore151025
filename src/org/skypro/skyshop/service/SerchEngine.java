package org.skypro.skyshop.service;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SerchEngine {
    private Map<String, Searchable> mapEngine;
    private int counter;


    public SerchEngine() {
        this.mapEngine = new TreeMap<>();

    }

    public Map<String, Searchable> search(String substring) {
        Map<String, Searchable> searchResult = new TreeMap();
        if (!mapEngine.isEmpty()) {
            for (Searchable element : mapEngine.values()) {
                if (element != null && element.searchTerm().contains(substring)) {
                    searchResult.put(createKeySearchEngine(element), element);
                }
            }
        } else {
            System.out.println(("Список mapEngine - пустой"));
        }
        return searchResult;
    }

    public void add(Searchable value) {
        String key = createKeySearchEngine(value);
        mapEngine.put(key, value);
        System.out.println("SerchEngine.add - поисковое имя = " + key + " :значение = " + value);
    }


    public Searchable maximumMatchCalculation(String search) throws BestResultNotFound {
        Searchable sear = null;
        int maxCount = 0;
        for (Searchable object : mapEngine.values()) {
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

    public String createKeySearchEngine(Searchable value) {
       //counter++;
        String key = value.searchTerm()  /*+ counter*/;
        return key;
    }

    @Override
    public String toString() {
        return "SerchEngine{" +
                "mapEngine=" + mapEngine +
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

