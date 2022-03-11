package com.jjeanjacques.solidgood.exception;

public class InvalidBusinessTransaction extends RuntimeException {

    public InvalidBusinessTransaction(String message) {
        super(message);
    }

}