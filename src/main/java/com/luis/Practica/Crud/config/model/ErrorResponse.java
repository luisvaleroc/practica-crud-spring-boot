package com.luis.Practica.Crud.config.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private final String error;
    private final String message;
    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
