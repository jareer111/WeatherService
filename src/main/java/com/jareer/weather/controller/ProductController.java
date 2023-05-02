package com.jareer.weather.controller;

import com.jareer.weather.entity.Product;
import com.jareer.weather.models.request.ProductRequestPayload;
import com.jareer.weather.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products")
    public List<Product> list() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product create(@RequestBody @Valid ProductRequestPayload productRequestPayload) {
        return productService.create(productRequestPayload);
    }
}
