package com.dworld.learn.orchestration.controllers;

import com.dworld.learn.orchestration.models.FulfilmentDates;
import com.dworld.learn.orchestration.models.FulfilmentOptions;
import com.dworld.learn.orchestration.models.Order;
import com.dworld.learn.orchestration.services.FulfimentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FulfilmentController {

    @Autowired
    FulfimentSourceService fulfilmentSourceService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/fulfilment-options")
    public FulfilmentOptions getFulfilmentOptions(@RequestBody  Order order) {
        String fulfilmentSource = fulfilmentSourceService.getFulfilmentSource(order.getProductId(), order.getQty());
        FulfilmentDates fulfilmentDates = fulfilmentSourceService.getFulfilmentDates(order.getProductId(),order.getQty(), fulfilmentSource);
    }
}
