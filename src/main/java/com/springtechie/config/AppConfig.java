package com.springtechie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean(name = "restTemplate") // this creates the bean with name  restTemplate
    @Scope("prototype")
    public RestTemplate getProductService() {
        return new RestTemplate();
    }
}
