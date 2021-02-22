package com.company;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int loadedToTruck = 0;
        TreeMap<SteelSheet, Integer> availableSheets = new TreeMap<>();
        availableSheets.put(new SteelSheet(563.),2);
        availableSheets.put(new SteelSheet(789.),5);
        availableSheets.put(new SteelSheet(365.),82);
        Warehouse mySheets = new Warehouse(availableSheets);
        mySheets = loadFront(mySheets);
        mySheets = loadBack(mySheets.getAvailableSheets().firstKey().getMass(),mySheets);
        System.out.println(mySheets);

    }
    //The maximum quantity to be loaded in the front part of the trailer- shouldn't exceed 10 tones (10k kilos)
     public static Warehouse loadFront(Warehouse currentSheets) {
        Double max = 9000.;

        while (max >= 0) {
            Double firstMass = currentSheets.getAvailableSheets().firstKey().getMass();
            currentSheets.exportFirstSheet();
            max -= firstMass;
        }
        return currentSheets;
    }
    //The maximum quantity to be loaded in the back part of the trailer- shouldn't exceed the difference between total quantity (max 24.5tones) and the front loaded quantity
    static Warehouse loadBack(Double frontMass, Warehouse currentSheets) {
        Double max = 24500 - frontMass;
        while (max >= 0) {
            Double firstMass = currentSheets.getAvailableSheets().firstKey().getMass();
            currentSheets.exportFirstSheet();
            max -= firstMass;
        }
        return currentSheets;
    }
}
