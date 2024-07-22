package com.luis.Practica.Crud.config;

import com.luis.Practica.Crud.config.model.ErrorResponse;
import com.luis.Practica.Crud.enums.ErrorCode;
import com.luis.Practica.Crud.exceptions.NotaNotFound;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NotaNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotaNotFound(NotaNotFound notaNotFound) {
        return new ErrorResponse("no enc", ErrorCode.NOTA_NOT_FOUND.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUncontrolledException(Exception exception) {
        return new ErrorResponse("Problema desconocido", ErrorCode.GENERAL_ERROR.getMessage());
    }
}
