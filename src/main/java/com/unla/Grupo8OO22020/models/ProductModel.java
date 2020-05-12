package com.unla.Grupo8OO22020.models;

public class ProductModel {
	
	
	private long idProduct;
	
	private String description;
	
	private double price;
	
	private String size;
	
	public ProductModel() {}
	
	public ProductModel(long idProduct,String description,double price,String size) {
		this.setIdProduct(idProduct);		
		this.description=description;
		this.price=price;
		this.size=size;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
}
