package com.example.ss3.service.impl;

import com.example.ss3.model.Product;
import com.example.ss3.repo.IProductRepo;
import com.example.ss3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productRepo.editProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteProduct(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> getList() {
        return productRepo.getList();
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }
}
