package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class WareHouseTest {

    @Test
    public void fillTest() {
        Sheet sheetMass3 = new Sheet(3.0, 124);
        Sheet sheetMass4 = new Sheet(4.0, 99);
        Sheet sheetMass5 = new Sheet(5.0, 204);
        Sheet sheetMass8 = new Sheet(8.0, 70);
        List<Sheet> availableSheets = new ArrayList<>();
        availableSheets.add(sheetMass3);
        availableSheets.add(sheetMass4);
        availableSheets.add(sheetMass5);
        availableSheets.add(sheetMass8);
        SheetDistribution sheetDistribution = new SheetDistribution();
        List<Sheet> result = sheetDistribution.processList(availableSheets, 1000.0);
        result.forEach(System.out::println);
        System.out.println("Total: " + result.stream().map(x -> x.getMass()*x.getCount()).reduce(0.0, Double::sum));
    }
}