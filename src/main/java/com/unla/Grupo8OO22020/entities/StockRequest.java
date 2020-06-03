package com.unla.Grupo8OO22020.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class StockRequest extends Pedido {

	@OneToOne(cascade=CascadeType.MERGE)
	private Store storeCollaborator;

	
	@OneToOne(cascade = CascadeType.MERGE, optional=true)
	private Employee collaborator; 
	
	public StockRequest() {}
	
	public StockRequest(long idPedido,int quantity,Product product,Store store,Employee employee,double subtotal,Store storeCollaborator , Employee collaborator) {
		super(idPedido,quantity,product,store,employee,subtotal);
	    this.storeCollaborator=storeCollaborator;
		this.collaborator=collaborator; 
	}

	public Store getStoreCollaborator() {
		return storeCollaborator;
	}

	public void setStoreCollaborator(Store storeCollaborator) {
		this.storeCollaborator = storeCollaborator;
	}

	public Employee getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Employee collaborator) {
		this.collaborator = collaborator;
	}
}