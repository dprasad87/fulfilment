package com.dworld.learn.orchestration.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter @Setter
@Document(collection = "orders")
public class Order {


    private String orderId;
    private String customerId;
    private String customerName;
    private String productId;
    private int qty;
    private Date orderDate;
    @DBRef
    private Address address;
    private float price;
}