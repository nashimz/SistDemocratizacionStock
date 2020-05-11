package com.unla.Grupo8OO22020.models;


public class LoteModel {
	
	private long idLote;
	
	private ProductoModel producto;
	
	private int cantidad;
	
	private int cantidadTotal;
	

	public LoteModel() {}

	public LoteModel(long idLote, ProductoModel producto, int cantidad, int cantidadTotal) {
		this.setIdLote(idLote);
		this.producto = producto;
		this.cantidad = cantidad;
		this.cantidadTotal = cantidadTotal;
	
	}

	public long getIdLote() {
		return idLote;
	}

	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

}