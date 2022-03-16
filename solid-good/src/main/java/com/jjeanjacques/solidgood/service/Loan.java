package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.domain.Pokeball;

import java.util.List;

public interface Loan extends Payment {
    void intiateLoanSettlement(List<Pokeball> items);
    List<Pokeball> initiateRePayment();
}
