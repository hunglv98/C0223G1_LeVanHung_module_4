package com.example.ss3.repo.impl;

import com.example.ss3.model.Product;
import com.example.ss3.repo.IProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl implements IProductRepo {
    private List<Product> list = new ArrayList<Product>() {
        {
            add(new Product(1, "Nokia", 2000, "Cục gạch", "Nokia"));
            add(new Product(2, "Iphone", 3000, "3GS", "Apple"));
            add(new Product(3, "Galaxy Fold 3", 4000, "Fold", "SamSung"));
            add(new Product(4, "Xperia", 1500, "Xperia", "Sony"));
            add(new Product(5, "Oppo Reno5", 2500, "Reno", "OPPO"));
        }
    };

    @Override
    public void addProduct(Product product) {
        list.add(product);
    }

    @Override
    public void editProduct(Product product) {
        for (Product p : list) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacturer(product.getManufacturer());
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                list.remove(p);
                break;
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product p : list) {
            if (p.getName().contains(name)) {
                searchList.add(p);
            }
        }
        return searchList;
    }

    @Override
    public List<Product> getList() {
        return list;
    }

    @Override
    public Product findById(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
