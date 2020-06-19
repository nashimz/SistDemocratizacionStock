package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.Nullable;

public class PedidoModel {
	
	private long idPedido;
	private int quantity;
	private ProductModel product;
	private StoreModel store;
	private EmployeeModel employee;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private double subtotal;
	@Nullable
	private EmployeeModel collaborator;
	private boolean accept;
	private ClientModel client;
	
	
	public PedidoModel() {}

	public PedidoModel(long idPedido, int quantity, ProductModel product,StoreModel store,EmployeeModel employee,LocalDate date,double subtotal,EmployeeModel collaborator,boolean accept,ClientModel client) {
		this.setIdPedido(idPedido);
		this.quantity = quantity;
		this.product = product;
		this.store=store;
		this.employee=employee;
		this.date=date;
		this.subtotal=subtotal;
		this.collaborator=collaborator;
		this.accept=accept;
		this.client=client;
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

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public StoreModel getStore() {
		return store;
	}

	public void setStore(StoreModel store) {
		this.store = store;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
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

	public EmployeeModel getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(EmployeeModel collaborator) {
		this.collaborator = collaborator;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}
	
	
}
