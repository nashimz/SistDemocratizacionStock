package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;

public class StockRequestModel extends PedidoModel {
	
	
	private StoreModel storeCollaborator;
	private EmployeeModel collaborator;
	private boolean accept;

	public StockRequestModel() {}

	public StockRequestModel(long idPedido, int quantity, ProductModel product,StoreModel store,EmployeeModel employee,LocalDate date,double subtotal,StoreModel storeCollaborator, EmployeeModel collaborator,boolean accept) {
		super(idPedido,quantity,product,store,employee,date,subtotal);
		this.storeCollaborator=storeCollaborator;
		this.collaborator=collaborator;
		this.accept=accept;
	}

	

	public StoreModel getStoreCollaborator() {
		return storeCollaborator;
	}

	public void setStoreCollaborator(StoreModel storeCollaborator) {
		this.storeCollaborator = storeCollaborator;
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

	
	

	
	
}