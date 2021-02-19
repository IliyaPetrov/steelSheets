package com.company;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<SteelSheet, Integer> availableSheets = new TreeMap<>();
        Warehouse mySheets = new Warehouse(availableSheets);
    }

    //The maximum quantity to be loaded in the front part of the trailer shouldn't exceed 10 tones (10k kilos)
    static void loadFront() {
        Double max = 9000.;



    }

    //The maximum quantity to be loaded in the back part of the trailer shouldn't exceed the difference between total quantity (max 24.5tones) and the front loaded quantity
    static void loadBack(Double frontLoad) {
        Double max = 24500 - frontLoad;


    }

}
