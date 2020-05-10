package com.unla.Grupo8OO22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lote")
public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idLote;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Producto producto;
	
	@Column(name="cantidad")
	int cantidad;
	
	@Column(name="cantidadTotal")
	int cantidadTotal;
	
	@Column(name="fechaIngreso")
	private LocalDate fechaIngreso;

	public Lote() {}

	public Lote(long idLote,Producto producto, int cantidad, int cantidadTotal,LocalDate fechaIngreso) {
		this.idLote=idLote;
		this.producto = producto;
		this.cantidad = cantidad;
		this.cantidadTotal = cantidadTotal;
		this.fechaIngreso=fechaIngreso;
	}
	
	public Lote(Producto producto, int cantidad, int cantidadTotal,LocalDate fechaIngreso) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.cantidadTotal = cantidadTotal;
		this.fechaIngreso=fechaIngreso;
	}

	public long getIdLote() {
		return idLote;
	}

	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
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
