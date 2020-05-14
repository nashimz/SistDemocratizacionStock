package com.unla.Grupo8OO22020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.converters.EmployeeConverter;
import com.unla.Grupo8OO22020.repositories.IEmployeeRepository;
import com.unla.Grupo8OO22020.services.*;
import com.unla.Grupo8OO22020.entities.*;
import java.util.*;

@Service("employeeService")
public class EmployeeService implements IEmployeeService {

		@Autowired
		@Qualifier("employeeRepository")
		private IEmployeeRepository employeeRepository;
		
		@Autowired
		@Qualifier("employeeConverter")
		private EmployeeConverter employeeConverter;
		
		@Override
		public List<Employee> getAll() {
			return employeeRepository.findAll();
		}

		@Override
		public EmployeeModel insertOrUpdate(EmployeeModel employeeModel) {
			Employee employee = employeeRepository.save(employeeConverter.modelToEntity(employeeModel));
			return employeeConverter.entityToModel(employee);
		}

		
		@Override
		public EmployeeModel findById(long id) {
			return employeeConverter.entityToModel(employeeRepository.findById(id));
		}
		
		
		@Override
		public EmployeeModel findByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean remove(long id) {
			try {
				employeeRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}


	
}