package com.example.springdiary;

import com.example.springdiary.model.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SpringdiaryApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {

	    SpringApplication.run(SpringdiaryApplication.class, args);
	}
}
