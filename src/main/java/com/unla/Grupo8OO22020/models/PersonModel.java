package com.unla.Grupo8OO22020.models;
import java.time.*;

public class PersonModel {

	
	private int id;
	
	private String name;
	private String surname;
	private LocalDate dateBirth;
	private long dni;
	
	public PersonModel() {}
	
	public PersonModel(int id, String name,String surname,LocalDate dateBirth,long dni) {
		this.setId(id);
		this.name = name;
		this.surname = surname;
		this.dateBirth = dateBirth;
		this.dni = dni;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}