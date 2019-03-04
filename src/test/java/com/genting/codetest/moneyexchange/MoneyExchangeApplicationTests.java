package com.genting.codetest.moneyexchange;

import com.genting.codetest.moneyexchange.entity.ExchangeValue;
import com.genting.codetest.moneyexchange.exception.AppException;
import com.genting.codetest.moneyexchange.exception.CurrencyNotFoundException;
import com.genting.codetest.moneyexchange.repo.ExchangeValueRepository;
import com.genting.codetest.moneyexchange.service.ExchangeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ActiveProfiles(profiles = {"test"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MoneyExchangeApplicationTests {

    @Mock
    ExchangeValueRepository exchangeValueRepository;

    @InjectMocks
    private ExchangeService exchangeService;

    @Test
    public void sellSGD() {

        when(exchangeValueRepository.findByCurrency("USD")).thenReturn(Optional.of(getExchangeValue()));
        Double actualValue = new Double(73.67025195226168);
        Double expectedValue = exchangeService.sellSGD("USD", "100");
        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void buySGD() {

        when(exchangeValueRepository.findByCurrency("USD")).thenReturn(Optional.of(getExchangeValue()));
        Double actualValue = new Double(133.92);
        Double expectedValue = exchangeService.buySGD("USD", "100");

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test(expected = CurrencyNotFoundException.class)
    public void shouldThrowCurrencyNotFoundException() {

        given(exchangeValueRepository.findByCurrency("ABC")).willReturn(Optional.empty());
        exchangeService.buySGD("ABC", "100");
    }


    @Test(expected = AppException.class)
    public void shouldThrowAppException() {

        given(exchangeValueRepository.findByCurrency("USD")).willReturn(Optional.of(getExchangeValue()));
        exchangeService.buySGD("USD", "100USD");
    }

    private ExchangeValue getExchangeValue() {
        return ExchangeValue.builder()
                .id(1L)
                .buy(1.3392)
                .sell(1.3574)
                .currency("USD")
                .build();
    }
}
