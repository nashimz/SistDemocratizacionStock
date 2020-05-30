package com.unla.Grupo8OO22020.entities;
  
import java.time.LocalDate;


import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Employee extends Person{
	
	@Column(name="manager")
	private boolean manager;
	
	@Column(name="starTime")
	private LocalTime startTime;
	
	@Column(name="endTime")
	private LocalTime endTime;
	
	@Column(name="basicSalary")
	private double basicSalary;
	
	@Column(name="commission")
	private double commission;
	
	//lado propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="store_id", nullable=false)
	private Store store;
	

	public Employee() {}

	public Employee(long id, String name, String surname, LocalDate dateBirth, long dni, boolean manager, LocalTime startTime,
			LocalTime endTime, double basicSalary, double commission,Store store) {
		super(id,name,surname,dateBirth,dni);
		this.manager = manager;
		this.startTime = startTime;
		this.endTime = endTime;
		this.basicSalary = basicSalary;
		this.commission = commission;
		this.store=store;
	}
	

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}	
}