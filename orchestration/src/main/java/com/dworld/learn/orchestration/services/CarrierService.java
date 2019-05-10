package com.dworld.learn.orchestration.services;

import com.dworld.learn.orchestration.models.FulfilmentDates;
import org.springframework.stereotype.Service;

@Service
public class CarrierService {
    public FulfilmentDates getFulfilmentDates(String productId, int qty, String source, String pincode) {
        FulfilmentDates fulfilmentDates = new FulfilmentDates();
        fulfilmentDates.setProductId(productId);
        fulfilmentDates.setFromDate("08-05-2019");
            fulfilmentDates.setToDate("18-05-2019");

        return fulfilmentDates;
    }
}
