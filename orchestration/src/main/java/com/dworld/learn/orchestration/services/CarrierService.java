package com.dworld.learn.orchestration.services;

import com.dworld.learn.orchestration.models.FulfilmentDates;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarrierService {
    public FulfilmentDates getFulfilmentDates(String productId, int qty, String fulfilmentSource) {
        FulfilmentDates fulfilmentDates = new FulfilmentDates();
        fulfilmentDates.setProductId(productId);
        fulfilmentDates.setFromDate(new Date("30-04-2019"));
        fulfilmentDates.setToDate(new Date("09-05-2019"));
        return fulfilmentDates;
    }
}
