package com.unla.Grupo8OO22020.entities;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idBatch;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	
	@Column(name="quantity")
	int quantity;
	
	@Column(name="quantities")
	int quantities;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;


	public Batch() {}

	public Batch(long idBatch,Product product, int quantity, int quantities) {
		this.idBatch=idBatch;
		this.product = product;
		this.quantity = quantity;
		this.quantities = quantities;

	}
	
	public Batch(Product product, int quantity, int quantities) {
		this.product = product;
		this.quantity = quantity;
		this.quantities = quantities;

	}

	public long getIdBatch() {
		return idBatch;
	}

	public void setIdBatch(long idBatch) {
		this.idBatch = idBatch;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}