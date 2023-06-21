package com.example.ss5_ss6.repo;

import com.example.ss5_ss6.model.Product;

import java.util.List;

public interface IProductRepo {
    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);

    List<Product> findByName(String name);

    List<Product> getList();

    Product findById(int id);

}
