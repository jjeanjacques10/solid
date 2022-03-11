package com.jjeanjacques.solidbad.exception;

public class InvalidBusinessTransaction extends RuntimeException {

    public InvalidBusinessTransaction(String message) {
        super(message);
    }

}