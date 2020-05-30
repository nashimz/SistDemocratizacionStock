package com.unla.Grupo8OO22020.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="stock_request")
public class StockRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStockRequest;
	
	private int quantity;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Store store1;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Store store2;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Employee employee; 
	
	@OneToOne(cascade = CascadeType.MERGE, optional=true)
	@JoinColumn(name="id_collaborator")
	private Employee collaborator; 
	
	public StockRequest() {}
	
	public StockRequest(int quantity,Product product,Store store1,Store store2, Employee employee, Employee collaborator) {
		this.quantity=quantity;
		this.product=product;
		this.store1= store1;
		this.store2=store2;
		this.employee=employee;
		this.collaborator=collaborator; 
	}
	
	public StockRequest(long idStockRequest, int quantity,Product product,Store store1,Store store2, Employee employee, Employee collaborator) {
		this.idStockRequest=idStockRequest;
		this.quantity=quantity;
		this.product=product;
		this.store1= store1;
		this.store2=store2;
		this.employee=employee;
		this.collaborator=collaborator; 
	}

	public long getIdStockRequest() {
		return idStockRequest;
	}

	public void setIdStockRequest(long idStockRequest) {
		this.idStockRequest = idStockRequest;
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

	public Store getStore1() {
		return store1;
	}

	public void setStore1(Store store1) {
		this.store1 = store1;
	}

	public Store getStore2() {
		return store2;
	}

	public void setStore2(Store store2) {
		this.store2 = store2;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Employee collaborator) {
		this.collaborator = collaborator;
	}


}