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
	
	// Todos los locales que tengan ese idproducto
		@Query("SELECT s FROM Store s JOIN FETCH s.batches b WHERE b.product.idProduct = (:idProduct)")
	public abstract List<Store> findByIdProduct(long idProduct);

		

}
