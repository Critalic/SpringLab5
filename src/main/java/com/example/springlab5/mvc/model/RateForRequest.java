package com.example.springlab5.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RateForRequest {
    private final int id;
    private final double course;
    private final String estimatedCurrency;
    private final String relativeCurrency;
    private final String date;
}
