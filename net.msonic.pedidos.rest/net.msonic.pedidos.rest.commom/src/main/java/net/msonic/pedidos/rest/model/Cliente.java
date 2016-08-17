package net.msonic.pedidos.rest.model;

public class Cliente {
	
	private long id;
	private String nombres;
	private String paterno;
	private String materno;
	private String segmento;
	
	private double lineaCredito;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public double getLineaCredito() {
		return lineaCredito;
	}

	public void setLineaCredito(double lineaCredito) {
		this.lineaCredito = lineaCredito;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	
	
	
	
}
