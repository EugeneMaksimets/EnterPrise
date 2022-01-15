package com.example.shop.service.impl;

import com.example.shop.model.Product;
import com.example.shop.service.ProductService;
import com.example.shop.storage.ProductStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product createProduct(Product product) {
        ProductStorage.productStorageList.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Product newProduct = new Product();
        for (Product tmp : ProductStorage.productStorageList) {
            if (tmp.getId().equals(product.getId())) {
                tmp.setPrice(product.getPrice());
                tmp.setName(product.getName());
                newProduct = tmp;
            }
        }
        return newProduct;
    }

    @Override
    public void deleteProduct(Product product) {
        ProductStorage.productStorageList.removeIf(tmp -> tmp.getId().equals(product.getId()));
    }

    @Override
    public Product getById(int id) {
        Product product = new Product();
        for (Product tmp : ProductStorage.productStorageList) {
            if (tmp.getId().equals(id)) {
                product = tmp;
            }
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        return ProductStorage.productStorageList;
    }

}
