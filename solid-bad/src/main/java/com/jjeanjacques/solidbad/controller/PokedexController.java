package com.jjeanjacques.solidbad.controller;

import com.jjeanjacques.solidbad.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {

    @Autowired
    PokedexService pokedexService;

    @GetMapping
    public void getAll(){

    }

}
