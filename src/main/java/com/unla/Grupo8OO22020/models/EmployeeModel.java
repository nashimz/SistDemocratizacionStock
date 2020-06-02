package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class EmployeeModel extends PersonModel{

	private boolean manager;
	private LocalTime startTime;
	private LocalTime endTime;
	private double basicSalary;
	private double commission;
	private StoreModel Store;
	
	
	
	public EmployeeModel() {
	}

	public EmployeeModel(long id, String name, String surname, LocalDate dateBirth, long dni, boolean manager, LocalTime startTime,
			LocalTime endTime, double basicSalary, double commission,StoreModel store) {
		super(id,name,surname,dateBirth,dni);
		this.manager = manager;
		this.startTime = startTime;
		this.endTime = endTime;
		this.basicSalary = basicSalary;
		this.commission = commission;
		this.Store=store;
	}

	

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public StoreModel getStore() {
		return Store;
	}

	public void setStore(StoreModel store) {
		Store = store;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}
}