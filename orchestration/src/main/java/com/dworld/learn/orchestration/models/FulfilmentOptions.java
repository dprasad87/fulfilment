package com.dworld.learn.orchestration.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fulfilment_options")
@Getter @Setter
public class FulfilmentOptions {
    private String productId;
    private String fulfilmentFromDate;
    private String fulfilmentToDate;
    private String orderId;
    private ProductDetails productDetails;
    private String fulfilmentSource;
    private String stockStatus;
    private String fulfilmentSourceStatus;
}
