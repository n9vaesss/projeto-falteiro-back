package com.projectfalteiro.falteiro.services.exception;

public class BarCodeAlreadyRegisteredException extends RuntimeException{
    public BarCodeAlreadyRegisteredException(String barCode){
        super("Code bar already registered");
    }
}
