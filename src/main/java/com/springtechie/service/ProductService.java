package com.springtechie.service;

import com.springtechie.entity.Product;
import com.springtechie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        System.out.println("service");
        this.productRepository = productRepository;
    }

    public Product getProduct(int id) {

        // select * from emp where id = 1;
       return productRepository.findById(id).get();

    }

    // to create Product
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "Product created Successfully";
    }

    // to delete the product
    public String deleteProduct(int id) {
    productRepository.deleteById(id);
        return "Product deleted Successfully of"+ id;
    }

    // to update the product
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "Product updated Successfully";
    }
}
