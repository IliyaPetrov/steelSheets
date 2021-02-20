package com.company;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.TreeMap;

@Data
@NoArgsConstructor

public class Warehouse {
    private TreeMap<SteelSheet, Integer> availableSheets = new TreeMap<>();
    public Warehouse(TreeMap<SteelSheet, Integer> availableSheets) {
        this.availableSheets = availableSheets;
    }
    void importSheet(SteelSheet sheet, Integer nr) {
        availableSheets.put(sheet, nr);
    }
    void exportFirstSheet(){
        exportSheet(availableSheets.firstKey(),1);
    }
    void exportSheet(SteelSheet sheet, Integer nr) {
        if (!availableSheets.containsKey(sheet)) {
            System.out.println("Out of stock!");
            return;
        }
        int availability = availableSheets.get(sheet);
        if (availability < nr) {
            String answer = String.format("Not enough sheets from this model, %d available!\n", availability);
            System.out.println(answer);
        }
        availableSheets.put(sheet, (availability - nr));
        System.out.format("%d sheets were exported\n", nr);
    }
}
