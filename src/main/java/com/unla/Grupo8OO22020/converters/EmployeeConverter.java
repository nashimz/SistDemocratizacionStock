package com.unla.Grupo8OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo8OO22020.entities.Employee;
import com.unla.Grupo8OO22020.models.EmployeeModel;

@Component("employeeConverter")
public class EmployeeConverter {
	
	public EmployeeModel entityToModel(Employee employee) {
		return new EmployeeModel(employee.getId(),employee.getName(),employee.getSurname(),employee.getDateBirth(),employee.getDni(),employee.isManager(), employee.getStartTime(), employee.getEndTime(), employee.getBasicSalary(), employee.getCommission(),employee.getStore()); 
	}
	
	public Employee modelToEntity(EmployeeModel employeeModel) {
		return new Employee(employeeModel.getId(),employeeModel.getName(),employeeModel.getSurname(),employeeModel.getDateBirth(),employeeModel.getDni()
				,employeeModel.isManager(), employeeModel.getStartTime(), employeeModel.getEndTime(), employeeModel.getBasicSalary(), employeeModel.getCommission()
				,employeeModel.getStore());
}
}