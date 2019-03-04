package com.genting.codetest.moneyexchange.controller;

import com.genting.codetest.moneyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/currency-exchange/buySGD/{currency}/value/{value}")
    public String buySGD(@PathVariable String currency, @PathVariable String value) {

     return " Convert from " + currency + " " + value + " to SGD you will get : " +
             exchangeService.buySGD(currency, value) + " SGD.";

    }

    @GetMapping("/currency-exchange/sellSGD/{currency}/value/{value}")
    public String sellSGD(@PathVariable String currency, @PathVariable String value) {

        return " Convert from SGD " + value +" to " + currency +" you will get : " +
                ""+ exchangeService.sellSGD(currency, value) +" "+ currency ;

    }

}