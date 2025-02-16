package com.springtechie.service;

import com.springtechie.entity.Product;

public interface ProductService{

     Product getProduct(int id);
     String saveProduct(Product product);
     String deleteProduct(int id);
     String updateProduct(Product product);
}
