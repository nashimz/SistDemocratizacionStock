package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.Grupo8OO22020.entities.*;

@Repository("employeeRepository")
public interface IEmployeeRepository extends JpaRepository<Employee, Serializable> {
	
	public abstract Employee findById(long id);
	
    @Query("SELECT e FROM Employee e JOIN FETCH e.store s WHERE s.idStore = (:idStore)")
    public abstract List<Employee> findByIdStore(long idStore);
    
    
}