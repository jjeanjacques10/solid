package com.jjeanjacques.solidbad.service;

import com.jjeanjacques.solidbad.domain.Item;
import com.jjeanjacques.solidbad.domain.MasterBall;
import com.jjeanjacques.solidbad.domain.Pokeball;
import com.jjeanjacques.solidbad.domain.UltraBall;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MarketService {

    public String buy(String item) {
        Item itemSelected = new Pokeball(BigDecimal.TEN);
        switch (item.toUpperCase()) {
            case "POKEBALL":
                itemSelected = new Pokeball(BigDecimal.TEN);
                break;
            case "MASTERBALL":
                itemSelected = new MasterBall(BigDecimal.valueOf(1000.0));
                break;
            case "ULTRABALL":
                itemSelected = new UltraBall(BigDecimal.valueOf(1000.0));
                break;
        }
        return itemSelected.buyItem();
    }

    public String sell(String item) {
        Item itemSelected = new Pokeball(BigDecimal.TEN);
        switch (item) {
            case "POKEBALL":
                itemSelected = new Pokeball(BigDecimal.TEN);
            case "MASTERBALL":
                itemSelected = new MasterBall(BigDecimal.valueOf(1000.0));
            case "ULTRABALL":
                itemSelected = new UltraBall(BigDecimal.valueOf(1000.0));
        }
        return itemSelected.sellItem();
    }
}
