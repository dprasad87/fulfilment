package com.dworld.learn.orchestration.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ProductDetails {
    private String productId;
    private String productName;
    private String productDesc;
    private long productImage;


}
