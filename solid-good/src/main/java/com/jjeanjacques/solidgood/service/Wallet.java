package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.domain.Pokeball;

import java.util.List;

public interface Wallet extends Payment {
    void initiatePayments(List<Pokeball> items);
}
