package com.unla.Grupo8OO22020.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idProducto;
	
	@Column(name="descripcion")
	String descripcion;
	
	@Column(name="precio")
	double precio;

	public Producto() {}

	public Producto(long idProducto, String descripcion, double precio) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(String descripcion, double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
