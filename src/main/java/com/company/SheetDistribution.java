package com.company;

import java.util.*;
import java.util.stream.Collectors;

class SheetDistribution {

    public List<Sheet> processList(List<Sheet> availableSheets, final Double massLimit) {
        List<Sheet> beforeFull = new ArrayList<>();
        Queue<Sheet> sheets = toQueue(availableSheets);
        double currentMass = 0;
        for (int i = 0; i < sheets.size(); i++) {
            Sheet head = sheets.poll();
            if (currentMass + head.getMass() < massLimit) {
                currentMass += head.getMass()*head.getCount();
                beforeFull.add(head);
            }
        }
        Double semiFull = beforeFull.stream().map(x -> x.getMass()*x.getCount()).reduce(0.0, Double::sum);
        if (semiFull > 0.0) {
            double target = massLimit - semiFull;
            Sheet theChange = getTheChange(Objects.requireNonNull(sheets.poll()), target);
            beforeFull.add(theChange);
        }
        return beforeFull;
    }

    private Queue<Sheet> toQueue(List<Sheet> availableSheets) {
        return availableSheets.stream()
                .map(x -> new Sheet(x.getMass(), x.getCount()))
                .sorted(Comparator.comparing(x-> x.getMass()*x.getCount()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private Sheet getTheChange(Sheet sheet, final double target) {
        long count = (long) (target / sheet.getMass());
        return new Sheet(sheet.getMass(), count);
    }
}