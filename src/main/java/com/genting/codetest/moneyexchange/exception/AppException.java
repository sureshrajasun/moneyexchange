package com.genting.codetest.moneyexchange.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -620418191145264127L;

    public AppException(String message) {
        super(message);
    }

}