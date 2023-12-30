package com.jsp.mySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = "com.jsp")// specifying the package name of rest controller class to spring boot
@EnableJpaRepositories(basePackages = "com.jsp.mySpringBoot.repository")//specifying the package name of repository to spring boot 
@EntityScan(basePackages = "com.jsp.mySpringBoot.dto")//specifying the package of our entity classes to spring boot
public class MySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}

}
