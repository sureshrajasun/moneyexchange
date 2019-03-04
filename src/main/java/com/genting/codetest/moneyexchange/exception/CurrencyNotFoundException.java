package com.genting.codetest.moneyexchange.exception;

public class CurrencyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6204181911452576422L;

    public CurrencyNotFoundException(String message) {
        super(message);
    }

}
