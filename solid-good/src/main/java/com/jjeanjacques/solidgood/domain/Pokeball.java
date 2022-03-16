package com.jjeanjacques.solidgood.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
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
