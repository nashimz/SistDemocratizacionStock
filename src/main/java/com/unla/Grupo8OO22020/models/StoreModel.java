package com.unla.Grupo8OO22020.models;

public class StoreModel {
	private int id;
	private long phone; 
	private String address;
	private float latitude;
	private float longitude;
	private String manager;
	
	public StoreModel () {}
	
	public StoreModel (int id, long phone,String address,float latitude, float longitude, String manager) {
		this.setId(id);
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
		this.manager = manager;
	}


}
