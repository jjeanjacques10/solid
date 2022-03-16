package com.jjeanjacques.solidgood.service.impl;

import com.jjeanjacques.solidgood.domain.Pokeball;
import com.jjeanjacques.solidgood.service.Wallet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService implements Wallet {

    private List<Pokeball> items;

    public WalletService() {
        this.items = new ArrayList<>();
    }

    @Override
    public void initiatePayments(List<Pokeball> items) {
        this.items.addAll(items);
    }

    @Override
    public boolean status() {
        return !this.items.isEmpty();
    }

    @Override
    public List<Pokeball> getItems() {
        return this.items;
    }

}
