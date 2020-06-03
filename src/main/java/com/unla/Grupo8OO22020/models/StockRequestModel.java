package com.unla.Grupo8OO22020.models;

public class StockRequestModel extends PedidoModel {
	
	
	private StoreModel storeCollaborator;
	private EmployeeModel collaborator;

	public StockRequestModel() {}

	public StockRequestModel(long idPedido, int quantity, ProductModel product,StoreModel store,EmployeeModel employee,double subtotal,StoreModel storeCollaborator, EmployeeModel collaborator) {
		super(idPedido,quantity,product,store,employee,subtotal);
		this.storeCollaborator=storeCollaborator;
		this.collaborator=collaborator; 
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
	
	
}