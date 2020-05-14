package com.unla.Grupo8OO22020.models;



public class BatchModel {
	
	private long idBatch;
	
	private ProductModel product;
	
	private int quantity;
	
	private int quantities;
	
	

	public BatchModel() {}

	public BatchModel(long idBatch, ProductModel product, int quantity, int quantities) {
		this.setIdBatch(idBatch);
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

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
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


	}