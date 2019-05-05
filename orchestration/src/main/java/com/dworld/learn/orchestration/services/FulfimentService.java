package com.dworld.learn.orchestration.services;

import com.dworld.learn.orchestration.constants.Constants;
import com.dworld.learn.orchestration.models.FulfilmentDates;
import com.dworld.learn.orchestration.models.FulfilmentOptions;
import com.dworld.learn.orchestration.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FulfimentService {

    @Autowired
    ProductService productService;
    @Autowired
    StockService stockService;
    @Autowired
    CarrierService carrierService;

    public String getFulfilmentSource(String productId) {

        return "Aditya Textile";
    }


    /**
     * Validates if the product delivery is serviceable at the given pincode
     * @return boolean
     */
    public boolean validateFulfilmentSource() {
        return true;
    }

    /*

     */
    public FulfilmentOptions getFulfilmentOptions(Order order) {

        FulfilmentOptions fulfilmentOptions = new FulfilmentOptions();
        fulfilmentOptions.setOrderId(order.getOrderId());
        fulfilmentOptions.setProductDetails(productService.getProductDetails(order.getProductId()));
        String fulfilmentSource = getFulfilmentSource(order.getProductId());
        if(validateFulfilmentSource()) {
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
