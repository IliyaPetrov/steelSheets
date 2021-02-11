package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
Map<SteelSheet,Integer> availableSheets = new HashMap<SteelSheet,Integer>();

    public Warehouse(Map<SteelSheet, Integer> availableSheets) {
        this.availableSheets = availableSheets;
    }

    void importSheet(SteelSheet sheet,Integer nr){
        availableSheets.put(sheet,nr);
    }

    void exportSheet(SteelSheet sheet,Integer nr){
        if (!availableSheets.containsKey(sheet)) {
            System.out.println("Out of stock!");
            return;
        }
        int availability = availableSheets.get(sheet);
        if (availability < nr){
            String answer = String.format("Not enough sheets from this model, %d available!\n", availability);
            System.out.println(answer);
        }
        availableSheets.put(sheet,(availability-nr));
        System.out.format("%d sheets were exported\n", nr);


    }
}