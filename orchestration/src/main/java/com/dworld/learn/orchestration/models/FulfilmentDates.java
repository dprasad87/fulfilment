package com.dworld.learn.orchestration.models;

import lombok.Data;

import java.util.Date;

@Data
public class FulfilmentDates {
    private String productId;
    private Date fromDate;
    private Date toDate;
}
