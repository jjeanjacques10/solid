package com.jjeanjacques.solidgood.domain;

import java.math.BigDecimal;

public class MasterBall extends ItemRare {

    public MasterBall(BigDecimal value, String location) {
        super(value, location);
    }
    
    @Override
    public String sellItem() {
        return "You received $" + getValue() + ", it's a rare ball";
    }
}
