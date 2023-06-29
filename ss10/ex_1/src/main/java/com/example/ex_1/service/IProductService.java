package com.example.ex_1.service;

import com.example.ex_1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    Product getProductById(int id);
}
