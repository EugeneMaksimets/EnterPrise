package com.example.shop.controller;

import com.example.shop.model.Product;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/delete")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping("/product/all")
    public List<Product> getAll() {
        return productService.getAll();
    }
}
