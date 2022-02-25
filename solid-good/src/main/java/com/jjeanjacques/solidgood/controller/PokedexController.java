package com.jjeanjacques.solidgood.controller;

import com.jjeanjacques.solidgood.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {

    @Autowired
    public PokedexService pokedexService;

    @GetMapping
    public void getAll(){

    }

}
