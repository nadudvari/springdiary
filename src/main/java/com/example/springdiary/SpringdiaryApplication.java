package com.example.springdiary;

import com.example.springdiary.model.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SpringdiaryApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {

	    SpringApplication.run(SpringdiaryApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder() ;
	}
}
