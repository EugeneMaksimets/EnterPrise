package com.example.shop.service;

import com.example.shop.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    Product getById(int id);

    List<Product> getAll();

}
