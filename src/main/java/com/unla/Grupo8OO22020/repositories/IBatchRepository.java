package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo8OO22020.entities.Batch;



@Repository("batchRepository")
public interface IBatchRepository extends JpaRepository<Batch, Serializable> {
	
	public abstract Batch findByIdBatch(long idBatch);
	
}
