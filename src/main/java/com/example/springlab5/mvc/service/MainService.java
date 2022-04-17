package com.example.springlab5.mvc.service;

import com.example.springlab5.mvc.DAO.RateDAO;
import com.example.springlab5.mvc.model.Rate;
import com.example.springlab5.mvc.model.RateForRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {
    private final RateDAO rateDAO;

    public MainService(RateDAO rateDAO) {
        this.rateDAO = rateDAO;
    }

    public Rate createRate(RateForRequest rate) {
        return rateDAO.createRate(verifyRate(rate));
    }

    public void createRates(RateForRequest... rates) {
        int[] result = rateDAO.createRates(
                Arrays.stream(rates)
                        .map(this::verifyRate)
                        .toArray(Rate[]::new));
        if(Arrays.stream(result).anyMatch(res -> res==0)) {
        }
    }

    public List<Rate> getAllRates() {
        return rateDAO.readRates().stream()
                .map(this::verifyRate)
                .collect(Collectors.toList());
    }

    public boolean updateRate(RateForRequest rateToUpdate, RateForRequest updated) {
        return rateDAO.updateRate(verifyRate(rateToUpdate), verifyRate(updated)) > 0;
    }

    public boolean deleteRate(RateForRequest rate) {
        return rateDAO.deleteRate(verifyRate(rate)) > 0;
    }

    public void deleteRates(RateForRequest... rates) {
        int[] result = rateDAO.deleteRates(
                Arrays.stream(rates)
                        .map(this::verifyRate)
                        .toArray(Rate[]::new));
        if(Arrays.stream(result).anyMatch(res -> res==0)) {
        }
    }

    private Rate verifyRate(RateForRequest rateForRequest) {
        return new Rate(rateForRequest.getId(), rateForRequest.getCourse(),
                Currency.getInstance(rateForRequest.getEstimatedCurrency()),
                Currency.getInstance(rateForRequest.getRelativeCurrency()),
                LocalDate.parse(rateForRequest.getDate()));
    }
}
