package org.skypro.skyshop.service;

public class SerchEngine {
    private Searchable[] arr;
    private static int counter;

    public SerchEngine(int size) {
        this.arr = new Searchable[size];
    }

    public Searchable[] search(String s) {
        int counter = 0;
        Searchable[] searchResult = new Searchable[5];
        if (counter <= searchResult.length-1) {
                for (Searchable value : arr) {
                    if (value != null && counter <= searchResult.length-1) {
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
        arr[counter] = value;
        counter++;
        value.toString();
    }

}
