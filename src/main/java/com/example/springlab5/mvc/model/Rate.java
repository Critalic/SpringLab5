package com.example.springlab5.mvc.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Currency;

@Data
@AllArgsConstructor
public class Rate {
    @EqualsAndHashCode.Exclude
    private int id;
    @EqualsAndHashCode.Exclude
    private double course;

    private Currency EstimatedCurrency;
    private Currency RelativeCurrency;
    private LocalDate date;
}
