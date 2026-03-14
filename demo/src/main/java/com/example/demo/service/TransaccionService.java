package com.example.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TransaccionesDTO;

@Service
public class TransaccionService {

	public void procesarTransaccion(TransaccionesDTO tx) {
		UUID uuid = UUID.randomUUID();
		
		tx.setUuidInterno(uuid);
		
		System.out.println("Transaccion generada con UUID: " + uuid);
	}
}
