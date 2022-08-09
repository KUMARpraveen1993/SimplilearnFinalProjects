package com.Simplilearn.Final.sporty.Shoes.project;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Sporty_Shoes_main {

	public static void main(String[] args) {
		SpringApplication.run(Sporty_Shoes_main.class, args);

	}

}
