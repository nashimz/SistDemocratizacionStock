package com.unla.Grupo8OO22020.services;

import java.util.List;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.models.BatchModel;

public interface  IBatchService {
	
	 
	    public  List<Batch> getAll();
	   
	    public  List<BatchModel> getAlls();
		
		public   BatchModel insert(BatchModel batchModel);
		
		public  BatchModel update(BatchModel batchModel);
		
		public  boolean remove(long idBatch);

		public  BatchModel findByIdBatch(long idBatch);
		
		public  List<BatchModel> findByIdStore(long idStore);
		
}
