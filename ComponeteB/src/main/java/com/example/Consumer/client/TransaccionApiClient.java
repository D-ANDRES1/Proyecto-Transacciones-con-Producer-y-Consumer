package com.example.Consumer.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.Consumer.dto.TransaccionesDTO;

import java.util.Map;

@Component
public class TransaccionApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url =
            "https://7e0d9ogwzd.execute-api.us-east-1.amazonaws.com/default/guardarTransacciones";

    public boolean enviarTransaccion(TransaccionesDTO transaccion) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<TransaccionesDTO> request = new HttpEntity<>(transaccion, headers);

            // Se espera un Map<String,Object> para leer JSON
            Map<String, Object> response = restTemplate.postForObject(url, request, Map.class);

            if (response != null && "Transaccion almacenada".equals(response.get("message"))) {
                System.out.println("Respuesta completa: " + response); // <-- JSON completo
                return true;
            } else {
                System.out.println("Error en respuesta: " + response);
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error enviando transacción: " + transaccion.getIdTransaccion());
            e.printStackTrace();
            return false;
        }
    }
}