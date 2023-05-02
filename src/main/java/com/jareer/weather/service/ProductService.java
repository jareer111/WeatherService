package com.jareer.weather.service;

import com.jareer.weather.entity.Product;
import com.jareer.weather.models.request.ProductRequestPayload;

import java.util.List;

public interface  ProductService {
    List<Product> getAllProducts();

    Product create(ProductRequestPayload productRequestPayload);
}
