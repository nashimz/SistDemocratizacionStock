package com.unla.Grupo8OO22020.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="local")

public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="telefono")
	private long telefono;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="gerente")
	private String gerente;
	
	public Local() {}
	
	public Local(int id, long telefono, String ubicacion, String gerente) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.ubicacion = ubicacion;
		this.gerente = gerente;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int idLocal) {
		this.id = idLocal;
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











