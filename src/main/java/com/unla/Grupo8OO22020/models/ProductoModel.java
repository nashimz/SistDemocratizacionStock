package com.unla.Grupo8OO22020.models;

public class ProductoModel {
	
	
	private long idProducto;
	
	private String descripcion;
	
	private double precio;
	
	private String talle;
	
	public ProductoModel() {}
	
	public ProductoModel(long idProducto,String descripcion,double precio,String talle) {
		this.setIdProducto(idProducto);		
		this.descripcion=descripcion;
		this.precio=precio;
		this.talle=talle;
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

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
	
	
}
