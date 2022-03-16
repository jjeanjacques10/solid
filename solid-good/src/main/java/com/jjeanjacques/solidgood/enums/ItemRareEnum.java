package com.jjeanjacques.solidgood.enums;

import com.jjeanjacques.solidgood.domain.*;

import java.math.BigDecimal;

public enum ItemRareEnum {

    MASTERBALL {
        public ItemRare get() {
            return new MasterBall(BigDecimal.valueOf(10000.00), "location");
        }
    };

    public ItemRare get() {
        return null;
    }

}
