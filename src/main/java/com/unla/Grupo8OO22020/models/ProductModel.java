package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductModel {
	
	
	private long idProduct;
	
	private String description;
	
	private double price;
	
	private String size;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	public ProductModel() {}
	
	public ProductModel(long idProduct,String description,double price,String size,LocalDate startDate) {
		this.setIdProduct(idProduct);		
		this.description=description;
		this.price=price;
		this.size=size;
		this.startDate=startDate;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
}
