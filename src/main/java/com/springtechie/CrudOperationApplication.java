package com.springtechie;

import com.springtechie.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
		ConfigurableApplicationContext run = SpringApplication.run(CrudOperationApplication.class, args);
		ProductServiceImpl bean = run.getBean(ProductServiceImpl.class);
		System.out.println(bean.hashCode());
		ProductServiceImpl bean2 = run.getBean(ProductServiceImpl.class);
		System.out.println(bean2.hashCode());
		ProductServiceImpl productServiceImpl = (ProductServiceImpl)run.getBean("pservice");
		ProductServiceImpl productServiceImpl1 = run.getBean("pservice", ProductServiceImpl.class);

	}

	// initialization
	@PostConstruct
	public void welcomeMessage() {
		System.out.println("Welcome to springtechie");
	}

	//clean up
	@PreDestroy
	public void destroy() {
		System.out.println("Bye!!");
	}


}
