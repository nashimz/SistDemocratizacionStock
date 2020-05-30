package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo8OO22020.entities.Store;


@Repository("storeRepository")
public interface IStoreRepository extends JpaRepository<Store, Serializable>{
	
	public abstract Store findByIdStore(long idStore);
	
	
}
