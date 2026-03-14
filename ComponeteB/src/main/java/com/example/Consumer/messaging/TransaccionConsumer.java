package com.example.Consumer.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.Consumer.client.TransaccionApiClient;
import com.example.Consumer.dto.LoteDTO;
import com.example.Consumer.dto.TransaccionesDTO;
import com.example.Consumer.service.ProcesamientoService;
import com.rabbitmq.client.Channel;

import java.util.UUID;

import org.springframework.amqp.core.Message;

@Component
public class TransaccionConsumer {

    private final TransaccionApiClient apiClient;
    private final ProcesamientoService procesamientoService;

    public TransaccionConsumer(
            TransaccionApiClient apiClient,
            ProcesamientoService procesamientoService) {
        this.apiClient = apiClient;
        this.procesamientoService = procesamientoService;
    }

    @RabbitListener(queues = {
            "cola.bac",
            "cola.bi",
            "cola.gyt",
            "cola.banrural"
    }, concurrency = "2"
    )
    public void consumirTransaccion(LoteDTO lote, Message message, Channel channel) {

        System.out.println("Procesando lote: " + lote.getLoteId());

        try {

            for (TransaccionesDTO transaccion : lote.getTransacciones()) {

                UUID uuid = transaccion.getUuidInterno();

                if (procesamientoService.yaProcesada(uuid)) {
                    System.out.println("[SKIP] Transacción duplicada: " + transaccion.getIdTransaccion());
                    continue;
                }

                System.out.println("[ENVIO] Transaccion: " + transaccion.getIdTransaccion());

                boolean exito = apiClient.enviarTransaccion(transaccion);

                if (exito) {
                    procesamientoService.marcarProcesada(uuid);
                    System.out.println("[ACK] Transacción exitosa: " + transaccion.getIdTransaccion());
                } else {
                    System.out.println("[NACK] Transacción fallida: " + transaccion.getIdTransaccion());
                    // Rechaza todo el lote y reintenta después
                    channel.basicNack(
                            message.getMessageProperties().getDeliveryTag(),
                            false,
                            true
                    );
                    return; // salir del listener para no enviar ACK del lote
                }
            }

            // Si todas las transacciones fueron exitosas, se confirma el lote
            channel.basicAck(
                    message.getMessageProperties().getDeliveryTag(),
                    false
            );

            System.out.println("[ACK] Lote procesado: " + lote.getLoteId());

        } catch (Exception e) {
            System.out.println("[ERROR] Procesando lote: " + lote.getLoteId());
            e.printStackTrace();

            try {
                channel.basicNack(
                        message.getMessageProperties().getDeliveryTag(),
                        false,
                        true
                );
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}