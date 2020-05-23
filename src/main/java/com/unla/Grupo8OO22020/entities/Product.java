package com.unla.Grupo8OO22020.entities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idProduct;
	
	@Column(name="description")
	String description;
	
	@Column(name="price")
	double price;
	
	@Column(name="size")
	String size;
	
	
	LocalDate startDate;
	
	

	public Product() {}

	public Product(long idProduct, String description, double price,String size,LocalDate startDate) {
		this.idProduct = idProduct;
		this.description = description;
		this.price = price;
		this.size=size;
		this.startDate=startDate;
	}

	public Product(String description, double price,String size) {
		this.description = description;
		this.price = price;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}	
}
