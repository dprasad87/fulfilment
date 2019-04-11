package com.dworld.learn.orchestration.services;

import com.dworld.learn.orchestration.models.FulfilmentDates;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FulfimentSourceService {

    public String getFulfilmentSource(String productId) {
        return "Aditya Textile";
    }



    public boolean validateFulfilmentSource() {
        return false;
    }
}
