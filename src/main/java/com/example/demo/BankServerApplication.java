package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.example.demo.controller","com.example.demo.service"})
public class BankServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServerApplication.class, args);
	}
}
