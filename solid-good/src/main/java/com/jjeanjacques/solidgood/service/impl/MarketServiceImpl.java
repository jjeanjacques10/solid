package com.jjeanjacques.solidgood.service.impl;

import com.jjeanjacques.solidgood.enums.ItemEnum;
import com.jjeanjacques.solidgood.service.MarketService;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

    @Override
    public String buy(ItemEnum item) {
        var itemSelected = item.get();
        return itemSelected.buyItem();
    }

    @Override
    public String sell(ItemEnum item) {
        var itemSelected = item.get();
        return itemSelected.sellItem();
    }
}
