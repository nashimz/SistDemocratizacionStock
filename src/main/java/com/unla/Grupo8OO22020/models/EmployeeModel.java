package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeModel extends PersonModel{

	private boolean manager;
    @Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime startTime;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime endTime;
	private double basicSalary;
	private double commission;
	private double fullSalary;
	private StoreModel store;
	
	
	
	public EmployeeModel() {
	}

	public EmployeeModel(long id, String name, String surname, LocalDate dateBirth, long dni, boolean manager, LocalTime startTime,
			LocalTime endTime, double basicSalary, double commission,double fullSalary,StoreModel store) {
		super(id,name,surname,dateBirth,dni);
		this.manager = manager;
		this.startTime = startTime;
		this.endTime = endTime;
		this.basicSalary = basicSalary;
		this.commission = commission;
		this.fullSalary=fullSalary;
		this.store=store;
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
	
	



	public double getFullSalary() {
		return fullSalary;
	}

	public void setFullSalary(double fullSalary) {
		this.fullSalary = fullSalary;
	}

	public StoreModel getStore() {
		return store;
	}

	public void setStore(StoreModel store) {
		this.store = store;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}


	
	
}