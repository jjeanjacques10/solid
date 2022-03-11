package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.enums.ItemEnum;

public interface MarketService {

    String buy(ItemEnum item);

    String sell(ItemEnum item);

}
