package com.jjeanjacques.solidbad.service;

import com.jjeanjacques.solidbad.domain.Pokeball;
import com.jjeanjacques.solidbad.exception.UnsupportedOperation;
import com.jjeanjacques.solidbad.interfaces.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements Payment {
    private List<Pokeball> items;

    public LoanService() {
        this.items = new ArrayList<>();
    }

    @Override
    public void initiatePayments(List<Pokeball> items) {
        throw new UnsupportedOperation("This is not a wallet payment");
    }

    @Override
    public boolean status() {
        return !this.items.isEmpty();
    }

    @Override
    public List<Pokeball> getItems() {
        return this.items;
    }

    @Override
    public void initiateLoanSettlement(List<Pokeball> items) {
        this.items.addAll(items);
    }

    @Override
    public List<Pokeball> initiateRePayment() {
        var tmpItems = this.items;
        this.items.removeAll(this.items);
        return tmpItems;
    }
}
