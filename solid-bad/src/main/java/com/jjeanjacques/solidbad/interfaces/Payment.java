package com.jjeanjacques.solidbad.interfaces;

import com.jjeanjacques.solidbad.domain.Pokeball;

import java.util.List;

public interface Payment {
    void initiatePayments(List<Pokeball> items);
    boolean status();
    List<Pokeball> getItems();

    void initiateLoanSettlement(List<Pokeball> items);
    List<Pokeball> initiateRePayment();
}