package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.Grupo8OO22020.entities.Store;


@Repository("storeRepository")
public interface IStoreRepository extends JpaRepository<Store, Serializable>{
	public abstract Store findByIdStore(long idStore);
	
	// Todas las personas que tengan un título con ese nombre (parámetro name)
		@Query("SELECT s FROM Store s JOIN FETCH s.batches b WHERE b.idBatch = (:idBatch)")
	public abstract List<Store> findByIdBatch(long idBatch);



}
