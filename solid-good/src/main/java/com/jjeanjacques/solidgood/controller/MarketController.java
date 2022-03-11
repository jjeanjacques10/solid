package com.jjeanjacques.solidgood.controller;

import com.jjeanjacques.solidgood.controller.dto.ItemMarketDTO;
import com.jjeanjacques.solidgood.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @PostMapping
    public ResponseEntity<String> buyItem(@RequestBody ItemMarketDTO itemMarketDTO) {
        var response = "Select valid action";
        if ("buy".equalsIgnoreCase(itemMarketDTO.getAction())) {
            response = marketService.buy(itemMarketDTO.getItem());
        } else if ("sell".equalsIgnoreCase(itemMarketDTO.getAction())) {
            response = marketService.sell(itemMarketDTO.getItem());
        }
        return ResponseEntity.ok(response);
    }

}
