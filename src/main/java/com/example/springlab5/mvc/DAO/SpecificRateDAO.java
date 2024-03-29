package com.example.springlab5.mvc.DAO;

import com.example.springlab5.mvc.model.Rate;

import java.time.LocalDate;
import java.util.Collection;

public interface SpecificRateDAO {
    Collection<Rate> getRatesByDate(LocalDate date);
    Collection<Rate> getRatesByCurrency(LocalDate date);
}
