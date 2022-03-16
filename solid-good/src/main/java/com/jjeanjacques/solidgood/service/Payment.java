package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.domain.Pokeball;

import java.util.List;

public interface Payment {
    boolean status();
    List<Pokeball> getItems();
}