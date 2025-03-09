package com.springtechie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SPELController {

    // to read string or int from properties
    @Value("${name}")
    private String name;

    // how to read list of values
    @Value("${available.product}")
    private List<String> values;

    // arthritic operation
    @Value("#{2+6}")
    private int add;

    // ternary operator expression
    @Value("#{10>20?true:false}")
    private boolean value;


    // to get first element of list
    @Value("#{helper.list[0]}")
    private String firstElement;

    // to invoke other class methods.
    @Value("#{helper.getCountry()}")
    private String country;

    @GetMapping("/test")
    public void testMethod() {

        System.out.println(name);
        System.out.println(values);
        System.out.println(add);
        System.out.println(value);
        System.out.println(firstElement);
        System.out.println(country);
    }




}
