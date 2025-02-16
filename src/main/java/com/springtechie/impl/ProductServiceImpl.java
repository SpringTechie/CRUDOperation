package com.springtechie.impl;

import com.springtechie.entity.Product;
import com.springtechie.repository.ProductRepository;
import com.springtechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        System.out.println("service");
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(int id) {

        // select * from emp where id = 1;
        return productRepository.findById(id).get();

    }

    // to create Product
    @Override
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "Product created Successfully";
    }

    // to delete the product
    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted Successfully of"+ id;
    }

    // to update the product
    @Override
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "Product updated Successfully";
    }
}
