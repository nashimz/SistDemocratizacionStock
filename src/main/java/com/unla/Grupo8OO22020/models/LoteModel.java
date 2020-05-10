package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;

public class LoteModel {
	
	private long idLote;
	
	private ProductoModel producto;
	
	private int cantidad;
	
	private int cantidadTotal;
	
	private LocalDate fechaIngreso;

	public LoteModel() {}

	public LoteModel(long idLote, ProductoModel producto, int cantidad, int cantidadTotal, LocalDate fechaIngreso) {
		this.setIdLote(idLote);
		this.producto = producto;
		this.cantidad = cantidad;
		this.cantidadTotal = cantidadTotal;
		this.fechaIngreso = fechaIngreso;
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

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
