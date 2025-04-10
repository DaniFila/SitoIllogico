package org.example.sitoillogico.controller;


import org.example.sitoillogico.exceptions.LoginErrorException;
import org.example.sitoillogico.exceptions.NoPermessiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class gestioneEccezioni {

    @ExceptionHandler(LoginErrorException.class)
    public String utenteNotFound(LoginErrorException e) {
        return "LoginErrore";
    }

    @ExceptionHandler(NoPermessiException.class)
    public String noPermessi(NoPermessiException e) {
        return "noPermessi";
    }
}
