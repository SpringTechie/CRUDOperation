package com.springtechie.service;

import com.springtechie.entity.Product;

import java.util.List;

public interface ProductService {

     Product getProduct(int id);
     String saveProduct(Product product);
     String deleteProduct(int id);
     String updateProduct(Product product);

     List<Product> fetchAllProducts(int size);
}
