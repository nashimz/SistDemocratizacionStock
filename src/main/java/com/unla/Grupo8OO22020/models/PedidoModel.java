package com.unla.Grupo8OO22020.models;

public class PedidoModel {
	
	private long idPedido;
	private int quantity;
	private ProductModel product;
	private StoreModel store;
	private EmployeeModel employee;
	private double subtotal;
	
	
	public PedidoModel() {}

	public PedidoModel(long idPedido, int quantity, ProductModel product,StoreModel store,EmployeeModel employee,double subtotal) {
		this.setIdPedido(idPedido);
		this.quantity = quantity;
		this.product = product;
		this.store=store;
		this.employee=employee;
		this.setSubtotal(subtotal);
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
