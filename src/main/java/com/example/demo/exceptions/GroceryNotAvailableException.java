package com.example.demo.exceptions;

public class GroceryNotAvailableException extends Throwable {
    public GroceryNotAvailableException(String s) {
        super(s);
    }
}
