package com.unla.Grupo8OO22020.entities;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.sun.istack.Nullable;

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
	
	@Column(name="date")
	LocalDate date;
	
	@Column(name="subtotal")
	double subtotal;
	
	@OneToOne(cascade = CascadeType.MERGE, optional=true)
	@JoinColumn(name="id_colaborador")
	private Employee collaborator;
	
	private boolean accept;
	
	public Pedido() {}
	
	public Pedido(long idPedido,int quantity,Product product,Store store,Employee employee,LocalDate date,double subtotal,Employee collaborator,boolean accept) {
		this.idPedido=idPedido;
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.employee=employee;
		this.date=date;
		this.subtotal=subtotal;
		this.collaborator=collaborator;
		this.accept=accept;
	}
	
	public Pedido(int quantity,Product product,Store store,Employee employee,LocalDate date,double subtotal,boolean accept) {
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.employee=employee;
		this.subtotal=subtotal;
		this.date=date;
		this.accept=accept;
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
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Employee getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Employee collaborator) {
		this.collaborator = collaborator;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
}
