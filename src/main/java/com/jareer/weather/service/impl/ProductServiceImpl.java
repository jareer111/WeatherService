package com.jareer.weather.service.impl;

import com.jareer.weather.entity.Product;
import com.jareer.weather.models.request.ProductRequestPayload;
import com.jareer.weather.repository.ProductRepository;
import com.jareer.weather.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductRequestPayload productRequestPayload) {
        Product product = new Product();
        product.setName(productRequestPayload.getName());
        product.setPrice(productRequestPayload.getPrice());
        return productRepository.save(product);
    }
}
