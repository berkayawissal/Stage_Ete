package com.example.demo.exception;

public class AdminNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AdminNotFoundException(String message) {
        super(message);
    }
}