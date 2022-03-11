package com.jjeanjacques.solidgood.domain;

import java.math.BigDecimal;

public class UltraBall extends Item {

    public UltraBall(BigDecimal value) {
        super(value);
    }

    @Override
    public String buyItem() {
        return "You bought this Ultraball for $" + getValue();
    }

    @Override
    public String sellItem() {
        return "You received $" + getValue() + ", it's very usefully and powerfully";
    }

}