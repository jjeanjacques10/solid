package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.enums.ItemEnum;
import com.jjeanjacques.solidgood.enums.ItemRareEnum;

public interface MarketService {

    String buy(ItemEnum item);

    String sell(ItemEnum item);

    String sell(ItemRareEnum item);

}
