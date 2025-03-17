package com.springtechie.impl;

import com.springtechie.entity.Product;
import com.springtechie.exceptions.ProductNotFoundException;
import com.springtechie.repository.ProductRepository;
import com.springtechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

@Service("pservice")
@Scope("prototype")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(int id) {

        // select * from emp where id = 1;
        // findById method returns the Optional object.
        // if we try to get value directly from Optional object by using get() method
        // it throws throws NoSuchElementException.
        Optional<Product> product = productRepository.findById(id);
        // to handle this we need check whether Optional object contains value or not.
        if (!product.isEmpty()) {
            return product.get();
        }
        throw new ProductNotFoundException("No product Found with this Id = " + id);

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
