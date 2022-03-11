package com.jjeanjacques.solidgood.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Item {

    private BigDecimal value;

    public String buyItem() {
        return "You bought this item for $" + value;
    }

    public String sellItem() {
        return "You received $" + value;
    }
}
