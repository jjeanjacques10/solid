package com.jjeanjacques.solidbad.domain;

import java.math.BigDecimal;

public class Pokeball extends Item {

    public Pokeball(BigDecimal value) {
        super(value);
    }

    @Override
    public String buyItem() {
        return "You bought this Pokeball for $" + getValue();
    }

    @Override
    public String sellItem() {
        return "You received $" + getValue() + ", it's very usefully";
    }

}
