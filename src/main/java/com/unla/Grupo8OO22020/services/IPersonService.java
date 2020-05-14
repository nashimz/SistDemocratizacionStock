package com.unla.Grupo8OO22020.services;
import com.unla.Grupo8OO22020.entities.Person;
import com.unla.Grupo8OO22020.models.PersonModel;

import java.util.*;

public interface IPersonService {
public List<Person> getAll();


	public PersonModel findById(int id);
	
	public PersonModel findByName(String name);
	
	public PersonModel insertOrUpdate(PersonModel personModel);
	
	public boolean remove(int id);
	
	
}