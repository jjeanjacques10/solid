package com.jjeanjacques.solidgood.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ItemRare {

    private BigDecimal value;
    private String location;

    public String getLocation() {
        return "Location of rare item: " + location;
    }

    public String sellItem() {
        return "You received $" + value;
    }
}