package com.example.Consumer.service;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class ProcesamientoService {

    private final Set<UUID> procesadas = ConcurrentHashMap.newKeySet();

    // usa un booleano y el metodo contains pra de sir si es un true o false si ya tiene ese uuid
    public boolean yaProcesada(UUID uuid) {
        return procesadas.contains(uuid);
    }

    public void marcarProcesada(UUID uuid) {
        procesadas.add(uuid);
    }
}