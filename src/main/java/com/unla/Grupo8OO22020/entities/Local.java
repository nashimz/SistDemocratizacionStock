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
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="latitud")
	private float latitud;
	
	@Column(name="longitud")
	private float longitud;
	
	@Column(name="gerente")
	private String gerente;
	
	public Local() {}
	
	public Local(int id, long telefono, String direccion,float latitud, float longitud , String gerente) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud=latitud;
		this.longitud = longitud;
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
         
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
                                                       


}
