package com.springtechie.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public Map<String,Object> handleException(ProductNotFoundException ex) {
        System.out.println("ProductNotFoundException");
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("error",ex.getMessage());
        errorMap.put("statuscode","400");
        return errorMap;
    }


    @ExceptionHandler(value = { NoSuchElementException.class})
    public Map<String,Object> handleException(NoSuchElementException ex) {
        System.out.println("Hello NoSuchElementException Exception");
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("error",ex.getMessage());
        errorMap.put("statuscode","400");
        return errorMap;
    }


    @ExceptionHandler(value = { RuntimeException.class})
    public Map<String,Object> handleException(RuntimeException ex) {
        System.out.println("Hello Runtime Exception");
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("error",ex.getMessage());
        errorMap.put("statuscode","400");
        return errorMap;
    }
}
