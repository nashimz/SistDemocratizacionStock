package com.unla.Grupo8OO22020.models;

import java.time.LocalDate;
import java.time.LocalTime;

//import com.unla.Grupo8OO22020.entities.Store;

public class EmployeeModel{
	private long id;
	private String name;
	private String surname;
	private LocalDate dateBirth;
	private long dni;
	private boolean manager;
	private LocalTime startTime;
	private LocalTime endTime;
	private double basicSalary;
	private double commission;
	private String store; // CLASE LOCAL
	
	public EmployeeModel() {
		super();
	}

	public EmployeeModel(long id, String name, String surname, LocalDate dateBirth, long dni, boolean manager, LocalTime startTime,
			LocalTime endTime, double basicSalary, double commission, String store) {
		this.setId(id);
		this.name = name;
		this.surname = surname;
		this.dateBirth = dateBirth;
		this.dni = dni;
		this.manager = false;
		this.startTime = startTime;
		this.endTime = endTime;
		this.basicSalary = basicSalary;
		this.commission = commission;
		this.store = store;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = false;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}