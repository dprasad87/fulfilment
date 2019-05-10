package com.dworld.learn.orchestration.models;

import lombok.Data;

@Data
public class FulfilmentDates {
    private String productId;
    private String fromDate;
    private String toDate;
}
