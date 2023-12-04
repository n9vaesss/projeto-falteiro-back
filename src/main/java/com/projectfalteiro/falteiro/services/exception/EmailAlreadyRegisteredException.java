package com.projectfalteiro.falteiro.services.exception;

public class EmailAlreadyRegisteredException extends RuntimeException{
    public EmailAlreadyRegisteredException(String email) {
        super("E-mail already registered");
    }
}
