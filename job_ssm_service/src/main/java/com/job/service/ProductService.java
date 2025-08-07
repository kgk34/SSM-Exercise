package com.job.service;

import com.job.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}
