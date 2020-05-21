package com.unla.Grupo8OO22020.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Employee manager;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="store")
	private Set<Batch> batches = new HashSet<Batch>();
	
	public Store() {}
	
	public Store(long idStore, long phone, String address,double latitude, double longitude, Employee manager) {
		super();
		this.idStore = idStore;
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.manager = manager;
	}
	
	public Store( long phone, String address,float latitude, float longitude, Employee manager) {
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager= manager;
	}	
                                                       
}
