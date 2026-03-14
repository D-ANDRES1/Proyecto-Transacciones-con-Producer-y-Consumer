package com.example.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;


import com.example.demo.dto.LoteDTO;
import com.example.demo.dto.TransaccionesDTO;


@Service
public class LoteService {
	
	private final TransaccionService transaccionService;
	private final BancoService bancoService;
	
	public LoteService(TransaccionService transaccionService, BancoService bancoService) {
		this.transaccionService = transaccionService;
        this.bancoService = bancoService;
	}

	public void procesarLote(LoteDTO lote) {
		UUID uuid = UUID.randomUUID();
		
		lote.setUuid(uuid);
		
		System.out.println("Procesando lote ID: "+ lote.getLoteId() +"UUID generado para lote: " + uuid + " Instante de la API: " + lote.getFechaGeneracion());
		
		for (TransaccionesDTO tx : lote.getTransacciones()) {
			
			try {
				
			transaccionService.procesarTransaccion(tx);
			
			} catch (Exception e) {
				System.out.println("Error procesando transaccion: " + tx.getIdTransaccion());
			}
			
		}
		
		bancoService.distribuirPorBanco(lote);
	}
	
}
