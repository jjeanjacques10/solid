package com.jjeanjacques.solidgood.enums;

import com.jjeanjacques.solidgood.domain.Item;
import com.jjeanjacques.solidgood.domain.Pokeball;
import com.jjeanjacques.solidgood.domain.UltraBall;

import java.math.BigDecimal;

public enum ItemEnum {

    POKEBALL {
        public Item get() {
            return new Pokeball(BigDecimal.valueOf(10.00));
        }
    },
    ULTRABALL {
        public Item get() {
            return new UltraBall(BigDecimal.valueOf(1000.00));
        }
    };

    public Item get() {
        return null;
    }

}
