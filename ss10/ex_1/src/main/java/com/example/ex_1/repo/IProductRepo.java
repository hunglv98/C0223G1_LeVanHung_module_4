package com.example.ex_1.repo;

import com.example.ex_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
