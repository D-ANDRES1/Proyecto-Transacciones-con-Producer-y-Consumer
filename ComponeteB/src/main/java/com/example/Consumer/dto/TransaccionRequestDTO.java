package com.example.Consumer.dto;

public class TransaccionRequestDTO {

    private String idTransaccion;
    private Double monto;
    private String moneda;
    private String cuentaOrigen;
    private String bancoDestino;

    private String nombre;
    private String carnet;
    
    public TransaccionRequestDTO() {
    	
    }

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
