package com.dworld.learn.orchestration.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "fulfilment_options")
@Getter @Setter
public class FulfilmentOptions {
    private String productId;
    private Date fulfilmentFromDate;
    private Date fulfilmentToDate;
    private String orderId;
    private ProductDetails productDetails;
    private String fulfilmentSource;
    private String stockStatus;
    private String fulfilmentSourceStatus;
}
