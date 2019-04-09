package com.dworld.learn.orchestration.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    private String porductId;
    private String productName;
}
