package com.example.springlab5.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Currency;

@Data
public class Rate {
    @EqualsAndHashCode.Exclude
    private double course;

    private Currency EstimatedCurrency;
    private Currency RelativeCurrency;
    private LocalDate date;
}
