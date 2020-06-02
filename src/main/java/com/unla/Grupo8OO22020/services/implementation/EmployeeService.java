package com.unla.Grupo8OO22020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.converters.EmployeeConverter;
import com.unla.Grupo8OO22020.entities.Employee;
import com.unla.Grupo8OO22020.repositories.IEmployeeRepository;
import com.unla.Grupo8OO22020.services.IEmployeeService;
import com.unla.Grupo8OO22020.services.IStoreService;


import java.util.ArrayList;
import java.util.List;

@Service("employeeService")
public class EmployeeService implements IEmployeeService {

		@Autowired
		@Qualifier("employeeRepository")
		private IEmployeeRepository employeeRepository;
		
		@Autowired
		@Qualifier("storeService")
		private IStoreService storeService;
		
		@Autowired
		@Qualifier("employeeConverter")
		private EmployeeConverter employeeConverter;
		
		@Override
		public List<Employee> getAll() {
			return employeeRepository.findAll();
		}

		@Override
		public EmployeeModel insertOrUpdate(EmployeeModel employeeModel) {
			employeeModel.setStore(storeService.findByIdStore(employeeModel.getStore().getIdStore()));
			Employee employee = employeeRepository.save(employeeConverter.modelToEntity(employeeModel));
			return employeeConverter.entityToModel(employee);
		}

		
		@Override
		public EmployeeModel findById(long id) {
			return employeeConverter.entityToModel(employeeRepository.findById(id));
		}
		
		public  List<EmployeeModel> findByIdStore(long idStore){
			List<EmployeeModel> models = new ArrayList<EmployeeModel>();
			for (Employee employee : employeeRepository.findByIdStore(idStore)) {
				models.add(employeeConverter.entityToModel(employee));
			}
			return models;
		}
		
		@Override
		public List<EmployeeModel> getAlls() {
			List<EmployeeModel> models = new ArrayList<EmployeeModel>();
			for (Employee employee : employeeRepository.findAll()) {
				models.add(employeeConverter.entityToModel(employee));
			}
			return models;
		}
		
		@Override
		public List<EmployeeModel> getAllv() {
			List<EmployeeModel> models = new ArrayList<EmployeeModel>();
			for (Employee employee : employeeRepository.findAll()) {
				if(!employee.isManager())
				models.add(employeeConverter.entityToModel(employee));
			}
			return models;
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