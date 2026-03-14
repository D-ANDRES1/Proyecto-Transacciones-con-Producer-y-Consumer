package com.example.demo.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.config.RabbitConfig;
import com.example.demo.dto.LoteDTO;
@Component
public class RabbitProducer {
	private final RabbitTemplate rabbitTemplate;
	
	public RabbitProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void enviarLotePorBanco(String banco, LoteDTO loteDTO) {
		
		String routingKey = "banco." + banco.toLowerCase().replace(" ", "");
		
		String exchange = RabbitConfig.EXCHANGE;
		
		rabbitTemplate.convertAndSend(exchange, routingKey, loteDTO);
		
		System.out.println("Lote enviado a banco: " + banco + " | routingKey: " + routingKey);
		
	}
	
	
}
