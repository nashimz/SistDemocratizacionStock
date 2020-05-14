package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Employee;
import com.unla.Grupo8OO22020.models.EmployeeModel;

import java.util.*;

public interface IEmployeeService {
	
	public List<Employee> getAll();
	
	public EmployeeModel findById(long id);
	
	public EmployeeModel findByName(String name);
		
	public EmployeeModel insertOrUpdate(EmployeeModel employeeModel);
	
	public boolean remove(long id);

}