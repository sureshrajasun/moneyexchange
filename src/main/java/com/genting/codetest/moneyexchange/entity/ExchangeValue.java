package com.genting.codetest.moneyexchange.entity;


import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
public class ExchangeValue {

    @Id
    private Long id;

    @Column
    private String currency;

    @Column
    private Double  buy;

    @Column
    private Double  sell;

    public ExchangeValue() {

    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public ExchangeValue(Long id, String currency, Double buy, Double sell) {
        this.id = id;
        this.currency = currency;
        this.buy = buy;
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "ExchangeValue{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}