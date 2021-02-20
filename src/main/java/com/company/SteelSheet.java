package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SteelSheet implements Comparable<SteelSheet> {
    // private Double width;
    //private Double height;
    //private Double length;
    private Double mass;
    public int compareTo(SteelSheet steelSheet) {
        if (this.getMass() > steelSheet.getMass()) {
            return 1;
        } else if (this.getMass() < steelSheet.getMass()) {
            return -1;
        }
        return 0;
    }
}
