package com.unla.Grupo8OO22020.repositories;



import java.io.Serializable;
	

import org.springframework.data.jpa.repository.JpaRepository;
	
import org.springframework.stereotype.Repository;

import com.unla.Grupo8OO22020.entities.*;

	@Repository("personRepository")
	public interface IPersonRepository extends JpaRepository<Person, Serializable> {
		
		public abstract Person findById(int id);
		
		public abstract Person findByName(String name);
		
		
	}
