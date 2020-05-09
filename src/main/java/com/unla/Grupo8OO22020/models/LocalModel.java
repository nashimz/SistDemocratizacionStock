package com.unla.Grupo8OO22020.models;

public class LocalModel {
	private int id;
	private long telefono;
	private String ubicacion;
	private String gerente;
	
	public LocalModel () {}
	
	public LocalModel (int id, long telefono,String ubicacion, String gerente) {
		this.setId(id);
		this.telefono = telefono;
		this.ubicacion = ubicacion;
		this.gerente = gerente;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}


}
