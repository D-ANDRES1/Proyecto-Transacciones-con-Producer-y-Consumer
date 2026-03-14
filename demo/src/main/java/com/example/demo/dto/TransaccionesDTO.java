package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;


public class TransaccionesDTO {

	private UUID uuidInterno;
	private String idTransaccion;
	private BigDecimal monto;
	private Currency moneda;
	private String cuentaOrigen;
	private String bancoDestino;
	private DetalleDTO detalle;

	public TransaccionesDTO() {

	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	
	public BigDecimal getMonto() {
		return monto;
	}
	
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	public Currency getMoneda() {
		return moneda;
	}
	
	public void setMoneda(Currency moneda) {
		this.moneda = moneda;
	}
	
	public String getCuentaOrigen() {
		return cuentaOrigen;
	}
	
	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	
	public String getBancoDestino() {
		return bancoDestino;
	}
	
	public void setBancoDestino(String bancoDestino) {
		this.bancoDestino = bancoDestino;
	}
	
	public DetalleDTO getDetalleDTO(){
		return detalle;
	}
	
	public void setDetalle(DetalleDTO detalle) {
		this.detalle = detalle;
	}

	public UUID getUuidInterno() {
		return uuidInterno;
	}

	public void setUuidInterno(UUID uuidInterno) {
		this.uuidInterno = uuidInterno;
	}

	@Override
	public String toString() {
		return "TransaccionesDTO [uuidInterno=" + uuidInterno + ", idTransaccion=" + idTransaccion + ", monto=" + monto
				+ ", moneda=" + moneda + ", cuentaOrigen=" + cuentaOrigen + ", bancoDestino=" + bancoDestino
				+ ", detalle=" + detalle + "]";
	}
	
	
	
}
