package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.unla.Grupo8OO22020.entities.*;

@Repository("clientRepository")
public interface IClientRepository extends JpaRepository<Client, Serializable> {
	
	public abstract Client findById(int id);
	
	
	
	
}
