package com.projectfalteiro.falteiro.services.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String id) {
        super("ID not found: " + id);
    }
}
