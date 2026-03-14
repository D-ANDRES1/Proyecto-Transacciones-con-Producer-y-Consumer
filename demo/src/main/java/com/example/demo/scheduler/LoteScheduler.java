package com.example.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.client.ApiClient;
import com.example.demo.dto.LoteDTO;
import com.example.demo.service.LoteService;

@Component
public class LoteScheduler {
	private final ApiClient apiClient;
	private final LoteService loteService;

	public LoteScheduler(ApiClient apiClient, LoteService loteService) {
        this.apiClient = apiClient;
        this.loteService = loteService;
    }

	@Scheduled(fixedDelay = 10000)
	public void ejecutar() {
		System.out.println("Consultando la API...");

		try {
			LoteDTO lote = apiClient.obtenerLote();

			if (lote == null) {
				System.out.println("No se recibio el lote");
				return;
			}

			if (lote.getTransacciones() == null || lote.getTransacciones().isEmpty()) {
				System.out.println("No hay transacciones en el lote");
				return;
			}

			loteService.procesarLote(lote);

		} catch (Exception e) {
			System.out.println("Error llamando a la API: ");
			e.printStackTrace();
		}
		
	}
}
