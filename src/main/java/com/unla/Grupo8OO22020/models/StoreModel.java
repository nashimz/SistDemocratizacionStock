package com.unla.Grupo8OO22020.models;

import java.util.HashSet;

import java.util.Set;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.entities.Employee;

public class StoreModel {
	private long idStore;
	private long phone; 
	private String address;
	private double latitude;
	private double longitude;
	private Set<Batch> batches = new HashSet<Batch>();
	private Set<Employee> Employees = new HashSet<Employee>();
	private double distance;

	public StoreModel () {}
	
	public StoreModel (long idStore, long phone,String address,double latitude, double longitude,double distance) {
		this.setIdStore(idStore);
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance=distance;
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

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	public Set<Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
