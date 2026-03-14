package com.example.Consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ComponeteBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponeteBApplication.class, args);
	}

}
