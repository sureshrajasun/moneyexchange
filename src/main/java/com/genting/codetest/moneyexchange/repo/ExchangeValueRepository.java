package com.genting.codetest.moneyexchange.repo;

import com.genting.codetest.moneyexchange.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

    Optional<ExchangeValue> findByCurrency(String currency);
}