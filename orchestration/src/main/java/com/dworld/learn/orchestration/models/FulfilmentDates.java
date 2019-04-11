package com.dworld.learn.orchestration.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class FulfilmentDates {
    private String productId;
    private Date fromDate;
    private Date toDate;
}
