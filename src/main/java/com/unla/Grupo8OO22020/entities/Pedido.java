package com.unla.Grupo8OO22020.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	private int quantity;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Store store;
	
	private boolean aceptado;

	public Pedido() {}
	
	public Pedido(long idPedido,int quantity,Product product,Store store, boolean aceptado) {
		this.idPedido=idPedido;
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.aceptado=aceptado;
		
	}
	
	public Pedido(int quantity,Product product,Store store,boolean aceptado) {
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.aceptado=aceptado;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
