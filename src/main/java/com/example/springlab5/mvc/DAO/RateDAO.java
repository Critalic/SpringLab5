package com.example.springlab5.mvc.DAO;

import com.example.springlab5.mvc.model.Rate;

import java.time.LocalDate;
import java.util.Collection;

public interface RateDAO {
    Rate createRate(Rate rate);
    Collection<Rate> readRates();
    void updateRate(Rate rateToUpdate, Rate updated);
    void deleteRate(Rate rateToDelete);

    Collection<Rate> getRatesByDate(LocalDate date);
    Collection<Rate> getRatesByCurrency(LocalDate date);
}