package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sheet{
    double mass;
    long count;
    double total;

    public Sheet(double mass, long count) {
        this.mass = mass;
        this.count = count;
    }
}