package com.example.demo.dto;



public class DetalleDTO {
	private String nombreBeneficiario;
	private String tipoTransferencia;
	private String descripcion;
	private ReferenciasDTO referencias;
	

	@Override
	public String toString() {
		return "DetalleDTO [nombreBeneficiario=" + nombreBeneficiario + ", tipoTransferencia=" + tipoTransferencia
				+ ", descripcion=" + descripcion + ", referencias=" + referencias + "]";
	}

	public DetalleDTO() {
		
	}
	
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}
	
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}
	
	public String getTipoTransferencia() {
		return tipoTransferencia;
	}
	
	public void setTipoTransferencia(String tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public ReferenciasDTO getReferencias() {
		return referencias;
	}

	public void setReferencias(ReferenciasDTO referencias) {
		this.referencias = referencias;
	}
	
}
