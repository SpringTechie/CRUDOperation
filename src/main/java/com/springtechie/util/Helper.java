package com.springtechie.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Helper {
    public List<String> list = List.of("arun","pawan");

    public String getCountry() {
        return "india";
    }
}
