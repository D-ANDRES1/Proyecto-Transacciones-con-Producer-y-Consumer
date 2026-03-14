package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoteDTO;
import com.example.demo.dto.TransaccionesDTO;
import com.example.demo.messaging.RabbitProducer;

@Service
public class BancoService {

    private final RabbitProducer rabbitProducer;

    public BancoService(RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    public void distribuirPorBanco(LoteDTO lote) {

        if (lote.getTransacciones() == null || lote.getTransacciones().isEmpty()) {
            System.out.println("⚠ Lote sin transacciones, no se envia a colas");
            return;
        }

        Map<String, List<TransaccionesDTO>> agrupadas = new HashMap<>();

        for (TransaccionesDTO tx : lote.getTransacciones()) {

            String banco = tx.getBancoDestino().toUpperCase();

            agrupadas
                .computeIfAbsent(banco, k -> new ArrayList<>())
                .add(tx);
        }

        for (Map.Entry<String, List<TransaccionesDTO>> entry : agrupadas.entrySet()) {

            String banco = entry.getKey();
            List<TransaccionesDTO> listaTransacciones = entry.getValue();

            LoteDTO loteBanco = new LoteDTO();
            loteBanco.setLoteId(lote.getLoteId());
            loteBanco.setUuid(lote.getUuid());
            loteBanco.setFechaGeneracion(lote.getFechaGeneracion());
            loteBanco.setTransacciones(listaTransacciones);
            
            try {
            
            rabbitProducer.enviarLotePorBanco(banco, loteBanco);
            
            }catch (Exception e) {
            	System.out.println("Error enviando lote al banco: " + banco);
			}
        }

        System.out.println("Lote distribuido por banco y enviado a RabbitMQ");
    }
}