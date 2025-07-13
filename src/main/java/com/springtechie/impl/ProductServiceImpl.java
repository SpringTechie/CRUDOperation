package com.springtechie.impl;

import com.springtechie.entity.Product;
import com.springtechie.exceptions.ProductNotFoundException;
import com.springtechie.repository.ProductRepository;
import com.springtechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;


@Service("pservice")
@Scope("prototype")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    Logger logger= LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(int id) {
        logger.info("Getting product from Db for id {}",id);
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

    @Override
    public List<Product> fetchAllProducts(int size) {
        List<Product> products = productRepository.findAll();
       return products.subList(0,size);
    }
}
