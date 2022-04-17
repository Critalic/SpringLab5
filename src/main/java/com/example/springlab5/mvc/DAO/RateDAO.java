package com.example.springlab5.mvc.DAO;

import com.example.springlab5.mvc.model.Rate;
import com.example.springlab5.mvc.model.RateForRequest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Currency;

public interface RateDAO {
    Rate createRate(Rate rate);

    int[] createRates(Rate... rates);

    Collection<RateForRequest> readRates();
    int updateRate(Rate rateToUpdate, Rate updated);
    int deleteRate(Rate rateToDelete);

    int[] deleteRates(Rate... ratesToDelete);

    Collection<Rate> getRatesByDate(LocalDate date);
    Collection<Rate> getRatesByCurrency(Currency currency);
}
