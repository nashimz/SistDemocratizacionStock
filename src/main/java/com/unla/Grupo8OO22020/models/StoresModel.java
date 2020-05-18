package com.unla.Grupo8OO22020.models;

public class StoresModel {
	
	private StoreModel store1;
	
	private StoreModel store2;

	public StoresModel(StoreModel store1, StoreModel store2) {
		super();
		this.store1 = store1;
		this.store2 = store2;
	}

	public StoreModel getStore1() {
		return store1;
	}

	public void setStore1(StoreModel store1) {
		this.store1 = store1;
	}

	public StoreModel getStore2() {
		return store2;
	}

	public void setStore2(StoreModel store2) {
		this.store2 = store2;
		
	}
	
	/*public  double distanciaCoord() {
		double radioTierra = 6371; //en kilómetros
		double dLat = Math.toRadians(this.getStore2().getLatitude()-this.getStore1().getLatitude());
		double dLng = Math.toRadians(this.getStore2().getLongitude() -this.getStore1().getLongitude());
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
		+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(this.getStore1().getLatitude())) * Math.cos(Math.toRadians(this.getStore2().getLatitude()));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
		}
	
	*/

	
	
}
