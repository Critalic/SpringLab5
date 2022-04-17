package com.example.springlab5.utils;

import com.example.springlab5.mvc.model.RateForRequest;

public class UpdateRateContainer {
    private final RateForRequest toUpdate;
    private final RateForRequest updated;

    public UpdateRateContainer(RateForRequest toUpdate, RateForRequest updated) {
        this.toUpdate = toUpdate;
        this.updated = updated;
    }

    public RateForRequest getToUpdate() {
        return toUpdate;
    }

    public RateForRequest getUpdated() {
        return updated;
    }
}
