package com.restmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.restmvc.services.IPerson;


@EnableTransactionManagement
@SpringBootApplication
public class SpringsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpringApplication.run(SpringsApplication.class, args);
		 
	}

}
