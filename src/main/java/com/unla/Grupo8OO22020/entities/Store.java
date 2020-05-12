package com.unla.Grupo8OO22020.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="store")

public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="latitude")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;
	
	@Column(name="manager")
	private String manager;
	
	public Store() {}
	
	public Store(int id, long phone, String address,float latitude, float longitude, String manager) {
		super();
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.manager = manager;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
         
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager= manager;
	}
                                                       


}
