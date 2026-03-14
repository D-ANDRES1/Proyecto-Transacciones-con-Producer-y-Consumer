package com.example.demo.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class LoteDTO {
	private UUID uuid;
	private String loteId;
	private Instant fechaGeneracion;
	private List<TransaccionesDTO> transacciones;
	
	public LoteDTO() {
		
	}
	
	public String getLoteId() {
		return loteId;
	}
	
	public void setLoteId(String loteId) {
		this.loteId = loteId;
	}
	
	public Instant getFechaGeneracion() {
		return fechaGeneracion;
	}
	
	public void setFechaGeneracion(Instant fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	
	public List<TransaccionesDTO> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<TransaccionesDTO> transacciones) {
		this.transacciones = transacciones;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "LoteDTO [uuid=" + uuid + ", loteId=" + loteId + ", fechaGeneracion=" + fechaGeneracion
				+ ", transacciones=" + transacciones + "]";
	}
	
	
	
}
