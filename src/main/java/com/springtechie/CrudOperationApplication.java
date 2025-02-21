package com.springtechie;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
		info = @Info(
				title = "CRUD-OPERATION",
				version = "1.0",
				description = "API's for my application"
		)
)
public class CrudOperationApplication {

	public static void main(String[] args) {
		 SpringApplication.run(CrudOperationApplication.class, args);

	}

}
