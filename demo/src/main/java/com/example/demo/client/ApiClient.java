package com.example.demo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.LoteDTO;


@Component
public class ApiClient {
	
	private final String url;
	private final RestTemplate restTemplate;
	
	public ApiClient(RestTemplate restTemplate) {
        this.url = "https://hly784ig9d.execute-api.us-east-1.amazonaws.com/default/transacciones";
        this.restTemplate = restTemplate;
    }
	
    public LoteDTO obtenerLote() {
    	
    	try {
        LoteDTO lote = restTemplate.getForObject(url, LoteDTO.class);
        return lote;
    	}catch (Exception e) {
    		System.out.println("Error consultando API: " + e.getMessage());
            return null;
		}
    }
}
