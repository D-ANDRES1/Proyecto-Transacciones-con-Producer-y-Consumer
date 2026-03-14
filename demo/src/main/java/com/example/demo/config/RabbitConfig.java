package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public static final String EXCHANGE = "exchange.bancos";
	public static final String COLA_BANRURAL = "cola.banrural";
	public static final String COLA_GYT = "cola.gyt";
	public static final String COLA_BAC = "cola.bac";
	public static final String COLA_BI = "cola.bi";

	@Bean
	Queue queueBanrural() {
		return new Queue(COLA_BANRURAL);
	}

	@Bean
	Queue queueGyt() {
		return new Queue(COLA_GYT);
	}

	@Bean
	Queue queueBac() {
		return new Queue(COLA_BAC);
	}

	@Bean
	Queue queueBi() {
		return new Queue(COLA_BI);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	Binding bindingBanrural(Queue queueBanrural, TopicExchange exchange) {
		return BindingBuilder.bind(queueBanrural).to(exchange).with("banco.banrural");
	}

	@Bean
	Binding bindingGyt(Queue queueGyt, TopicExchange exchange) {
		return BindingBuilder.bind(queueGyt).to(exchange).with("banco.gyt");
	}

	@Bean
	Binding bindingBac(Queue queueBac, TopicExchange exchange) {
		return BindingBuilder.bind(queueBac).to(exchange).with("banco.bac");
	}

	@Bean
	Binding bindingBi(Queue queueBi, TopicExchange exchange) {
		return BindingBuilder.bind(queueBi).to(exchange).with("banco.bi");
	}
}
