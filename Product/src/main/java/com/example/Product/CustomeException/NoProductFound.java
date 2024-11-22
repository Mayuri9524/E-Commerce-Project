package com.example.Product.CustomeException;

public class NoProductFound extends RuntimeException {
    public NoProductFound(String message) {
        super(message);
    }
}
