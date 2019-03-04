package com.genting.codetest.moneyexchange.controller;

import com.genting.codetest.moneyexchange.exception.AppException;
import com.genting.codetest.moneyexchange.exception.CurrencyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerErrorHandler.class);

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<String> handleCurrencyNotFoundException(CurrencyNotFoundException e) {
        logger.error("CurrencyNotFoundException occurs.", e);
        return new ResponseEntity<>("Currency Not Found.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<String> handleGeneralException(AppException e) {
        logger.error("Exception occurs.", e);
        return new ResponseEntity<>("Application Exception", HttpStatus.BAD_REQUEST);
    }

}
