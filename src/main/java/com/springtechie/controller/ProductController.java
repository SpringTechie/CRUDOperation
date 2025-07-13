package com.springtechie.controller;

import com.springtechie.entity.Product;
import com.springtechie.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@Tag(name="Product-Controller",description = "This controller has product related API's")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // to fetch the product
    @GetMapping("/get/id/{id}")
    @Operation(summary = "Find product By Id",description = "This helps to find the product by Product Id")
    @Parameter(name="id",description = "Enter Product Id",example = "1")
    @ApiResponse(responseCode = "200",description = "ProductFound with given Id")
    @ApiResponse(responseCode = "204",description = "No Product Found with Given Id")
    @ApiResponse(responseCode = "400",description = "Bad Request")
    public Product fetchProduct(@PathVariable int id) {
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


    @GetMapping("all/products")
    public List<Product> getAllProducts(@RequestParam int size) {
        if(size>=0) {
            return productService.fetchAllProducts(size);
        }
        throw new RuntimeException("Size should not be negative");
    }
}
