package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Employee;

import com.unla.Grupo8OO22020.models.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
	
	public List<Employee> getAll();
	
	public List<EmployeeModel> getAlls();
	
	public EmployeeModel findById(long id);
		
	public EmployeeModel insertOrUpdate(EmployeeModel employeeModel);
	
	public boolean remove(long id);
	
	public  List<EmployeeModel> findByIdStore(long idStore);

}