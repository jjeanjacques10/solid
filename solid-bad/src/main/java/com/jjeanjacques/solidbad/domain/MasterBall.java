package com.jjeanjacques.solidbad.domain;

import com.jjeanjacques.solidbad.exception.InvalidBusinessTransaction;

import java.math.BigDecimal;

public class MasterBall extends Item {

    public MasterBall(BigDecimal value) {
        super(value);
    }

    @Override
    public String buyItem() {
        // You can't buy a MasterBall
        throw new InvalidBusinessTransaction("It's impossible buy this item");
    }

    @Override
    public String sellItem() {
        return "You received $" + getValue() + ", it's a rare ball";
    }
}
