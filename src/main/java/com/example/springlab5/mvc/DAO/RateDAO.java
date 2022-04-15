package com.example.springlab5.mvc.DAO;

import com.example.springlab5.mvc.model.Rate;
import com.example.springlab5.mvc.model.RateForRequest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Currency;

public interface RateDAO {
    Rate createRate(Rate rate);
    Collection<RateForRequest> readRates();
    void updateRate(Rate rateToUpdate, Rate updated);
    int deleteRate(Rate rateToDelete);

    Collection<Rate> getRatesByDate(LocalDate date);
    Collection<Rate> getRatesByCurrency(Currency currency);
}
