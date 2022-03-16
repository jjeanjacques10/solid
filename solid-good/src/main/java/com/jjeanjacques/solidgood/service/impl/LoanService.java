package com.jjeanjacques.solidgood.service.impl;

import com.jjeanjacques.solidgood.domain.Pokeball;
import com.jjeanjacques.solidgood.service.Loan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements Loan {
    private List<Pokeball> items;

    public LoanService() {
        this.items = new ArrayList<>();
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
    public void intiateLoanSettlement(List<Pokeball> items) {
        this.items.addAll(items);
    }

    @Override
    public List<Pokeball> initiateRePayment() {
        var tmpItems = this.items;
        this.items.removeAll(this.items);
        return tmpItems;
    }
}
