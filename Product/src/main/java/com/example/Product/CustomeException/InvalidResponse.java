package com.example.Product.CustomeException;

public class InvalidResponse extends RuntimeException {
    public InvalidResponse(String message) {
        super(message);
    }
}
