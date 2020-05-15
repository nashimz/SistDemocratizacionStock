package com.unla.Grupo8OO22020.entities;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;



@Entity
@Table(name="store")

public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStore;
	
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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
	private Set<Batch> batches = new HashSet<Batch>();
	
	public Store() {}
	
	public Store(long idStore, long phone, String address,float latitude, float longitude, String manager) {
		super();
		this.idStore = idStore;
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.manager = manager;
	}
	
	public Store( long phone, String address,float latitude, float longitude, String manager) {
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.manager = manager;
	}
	
	public long getIdStore() {
		return idStore;
	}

	public void setIdStore(long idStore) {
		this.idStore = idStore;
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
