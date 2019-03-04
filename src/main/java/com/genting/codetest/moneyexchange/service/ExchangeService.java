package com.genting.codetest.moneyexchange.service;

import com.genting.codetest.moneyexchange.entity.ExchangeValue;
import com.genting.codetest.moneyexchange.exception.AppException;
import com.genting.codetest.moneyexchange.exception.CurrencyNotFoundException;
import com.genting.codetest.moneyexchange.repo.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExchangeService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeService.class);

    @Autowired
    private ExchangeValueRepository repository;

    public Double buySGD(String currency, String value) throws CurrencyNotFoundException {

        ExchangeValue exchangeValue = getCurrency(currency);
        logger.debug(" Exchange value object : {}", exchangeValue.toString());
        Double currValue = getCurrencyValue(value);
        Double conversionRate;
        conversionRate = currValue * exchangeValue.getBuy();

        logger.debug(" Convert from {} {} to SGD you will get : {} SGD", currency, value, conversionRate);
        return conversionRate;
    }

    public Double sellSGD(String currency, String value)throws CurrencyNotFoundException {

        ExchangeValue exchangeValue = getCurrency(currency);
        logger.debug(" Exchange value object : {}", exchangeValue.toString() );

        Double currValue = getCurrencyValue(value);
        Double conversionRate ;
        conversionRate =  currValue /  exchangeValue.getSell() ;

        logger.debug(" Convert from SGD {} to {} you will get : {} ", value, currency, conversionRate );

        return conversionRate;

    }

    private Double getCurrencyValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new AppException(String.format("Currency value %s is invalid.", value));
        }
    }

    private ExchangeValue getCurrency(String currency){
        Optional<ExchangeValue> exchangeValueOptional = repository.findByCurrency(currency);
        if(exchangeValueOptional.isPresent()) {
           return exchangeValueOptional.get();
        }else {
            throw new CurrencyNotFoundException(String.format("'%s' Currency Not Found.", currency));
        }
    }
}
