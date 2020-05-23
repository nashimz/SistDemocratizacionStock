package com.unla.Grupo8OO22020.models;


public class StoreModel {
	private long idStore;
	private long phone; 
	private String address;
	private double latitude;
	private double longitude;
	private EmployeeModel manager;
	
	
	public StoreModel () {}
	
	public StoreModel (long idStore, long phone,String address,double latitude, double longitude, EmployeeModel manager) {
		this.setIdStore(idStore);
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

	public EmployeeModel getManager() {
		return manager;
	}

	public void setManager(EmployeeModel manager) {
		this.manager = manager;
	}
}
