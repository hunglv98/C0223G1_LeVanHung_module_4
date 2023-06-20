package com.example.ss3.service;

import com.example.ss3.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);

    List<Product> findByName(String name);

    List<Product> getList();

    Product findById(int id);
}
