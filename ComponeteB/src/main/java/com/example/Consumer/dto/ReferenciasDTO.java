package com.example.Consumer.dto;

public class ReferenciasDTO {
	private String factura;
	private String codigoInterno;
	
	public ReferenciasDTO() {}

	@Override
	public String toString() {
		return "Referencias [factura=" + factura + ", codigoInterno=" + codigoInterno + "]";
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
}
