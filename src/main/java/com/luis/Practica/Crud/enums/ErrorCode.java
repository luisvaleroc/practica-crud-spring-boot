package com.luis.Practica.Crud.enums;

public enum  ErrorCode {

    NOTA_NOT_FOUND("Nota not found"),
    GENERAL_ERROR("An unexpected error occurred");

    private final String message;

    ErrorCode(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
