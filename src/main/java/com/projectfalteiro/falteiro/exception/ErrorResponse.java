package com.projectfalteiro.falteiro.exception;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {
    @Getter @Setter
    private Integer status;
    @Getter @Setter
    private String message;

    public ErrorResponse() {

    }

    public ErrorResponse(Integer status, String message){
        this.status = status;
        this.message = message;
    }

}
