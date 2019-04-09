package com.dworld.learn.orchestration.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addreses")
public class Address {
    @Id
    private String addressId;
    private String pincode;
    private String city;
    private String street;
    private String houseNo;
    private String landmark;

}
