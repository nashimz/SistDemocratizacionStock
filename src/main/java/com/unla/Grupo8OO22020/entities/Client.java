package com.unla.Grupo8OO22020.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Client extends Person {
	private long id;
	private String name;
	private String surname;
	private LocalDate dateBirth;
	private long dni;
	private String mail;
	
	
	
	public Client() {
		super();
	}
	public Client(long id,String name,String surname,LocalDate dateBirth,long dni, String mail) {
		this.setId(id);
		this.name = name;
		this.surname = surname;
		this.dateBirth = dateBirth;
		this.dni = dni;
		this.mail = mail;
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
	
}