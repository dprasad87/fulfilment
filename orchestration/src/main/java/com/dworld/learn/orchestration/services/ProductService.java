package com.dworld.learn.orchestration.services;

import com.dworld.learn.orchestration.models.ProductDetails;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductDetails getProductDetails(String productId) {
        return new ProductDetails(productId, "Some Product Name", "Some Product Desc", 1234l );
    }
}
