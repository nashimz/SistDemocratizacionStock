package com.unla.Grupo8OO22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "idPedido")
@Table(name="stockRequest")
public class StockRequest extends Pedido {
	
	private boolean accept;

	@OneToOne(cascade=CascadeType.MERGE)
	private Store storeCollaborator;
	
	@OneToOne(cascade = CascadeType.MERGE, optional=true)
	private Employee collaborator; 
	
	public StockRequest() {}
	
	public StockRequest(long idPedido,int quantity,Product product,Store store,Employee employee,LocalDate date,double subtotal,Store storeCollaborator , Employee collaborator,boolean accept) {
		super(idPedido,quantity,product,store,employee,date,subtotal);
	    this.storeCollaborator=storeCollaborator;
		this.collaborator=collaborator; 
		this.accept=accept;
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

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}
}