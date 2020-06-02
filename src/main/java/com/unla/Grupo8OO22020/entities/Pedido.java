package com.unla.Grupo8OO22020.entities;

import javax.persistence.CascadeType;


import javax.persistence.Column;
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
	
	@Column(name="quantity")
	private int quantity;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Store store;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Employee employee;
	
	@Column(name="subtotal")
	double subtotal;

	public Pedido() {}
	
	public Pedido(long idPedido,int quantity,Product product,Store store,Employee employee,double subtotal) {
		this.idPedido=idPedido;
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.employee=employee;
		this.subtotal=subtotal;
	}
	
	public Pedido(int quantity,Product product,Store store,Employee employee,double subtotal) {
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.employee=employee;
		this.subtotal=subtotal;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getSubtotal() {
		return this.product.getPrice()*this.quantity;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
