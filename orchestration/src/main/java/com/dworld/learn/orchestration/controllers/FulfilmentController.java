package com.dworld.learn.orchestration.controllers;

import com.dworld.learn.orchestration.constants.Constants;
import com.dworld.learn.orchestration.models.FulfilmentDates;
import com.dworld.learn.orchestration.models.FulfilmentOptions;
import com.dworld.learn.orchestration.models.Order;
import com.dworld.learn.orchestration.services.CarrierService;
import com.dworld.learn.orchestration.services.FulfimentSourceService;
import com.dworld.learn.orchestration.services.ProductService;
import com.dworld.learn.orchestration.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FulfilmentController {

    @Autowired
    FulfimentSourceService fulfilmentSourceService;
    @Autowired
    ProductService productService;
    @Autowired
    StockService stockService;
    @Autowired
    CarrierService carrierService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/fulfilment-options")
    public FulfilmentOptions getFulfilmentOptions(@RequestBody  Order order) {
        FulfilmentOptions fulfilmentOptions = new FulfilmentOptions();
        fulfilmentOptions.setOrderId(order.getOrderId());
        fulfilmentOptions.setProductDetails(productService.getProductDetails(order.getProductId()));
        String fulfilmentSource = fulfilmentSourceService.getFulfilmentSource(order.getProductId());
        if(fulfilmentSourceService.validateFulfilmentSource()) {
            fulfilmentOptions.setFulfilmentSourceStatus(Constants.FULFILMENT_SOURCE_MATCH);
            if(stockService.validateStock()) {
                FulfilmentDates fulfilmentDates = carrierService.getFulfilmentDates(order.getProductId(), order.getQty(), fulfilmentSource, order.getAddress().getPincode());
                fulfilmentOptions.setFulfilmentFromDate(fulfilmentDates.getFromDate());
                fulfilmentOptions.setFulfilmentToDate(fulfilmentDates.getToDate());
                fulfilmentOptions.setFulfilmentSource(fulfilmentSource);
                fulfilmentOptions.setStockStatus(Constants.STOCK_AVAILABLE);
            } else {
                fulfilmentOptions.setStockStatus(Constants.STOCK_OUT_OF_STOCK);
            }
        } else {
            fulfilmentOptions.setFulfilmentSourceStatus(Constants.FULFILMENT_SOURCE_MISMATCH);
        }
        return fulfilmentOptions;
    }
}
