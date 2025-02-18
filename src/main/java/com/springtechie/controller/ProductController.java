package com.springtechie.controller;

import com.springtechie.entity.Product;
import com.springtechie.impl.ProductServiceImpl;
import com.springtechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // to fetch the product
    @GetMapping("/get/id/{id}")
    public Product getProduct(@PathVariable int id) {
       return productService.getProduct(id);
    }

    // to create Product
    @PostMapping(value = "/save",consumes = "application/json",produces = "application/json")
    public String saveProduct( @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // to delete the product
    @DeleteMapping("/delete/id/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    // to update the product
    // if the object is found , then it will update the product else it will create new object.
    @PutMapping("/update")
    public String updateProduct( @RequestBody Product product) {
        return productService.updateProduct(product);
    }

}
