package com.example.ex_1.service.impl;

import com.example.ex_1.model.Product;
import com.example.ex_1.repo.IProductRepo;
import com.example.ex_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> getList() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id);
    }
}
