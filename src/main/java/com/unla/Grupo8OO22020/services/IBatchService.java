package com.unla.Grupo8OO22020.services;

import java.util.List;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.models.BatchModel;




public interface  IBatchService {
	
	 
	    public abstract List<Batch> getAll();
	   
	    public abstract List<BatchModel> getAlls();
		
		public abstract  BatchModel insert(BatchModel batchModel);
		
		public abstract BatchModel update(BatchModel batchModel);
		
		public abstract boolean remove(long idBatch);

		public abstract BatchModel findByIdBatch(long idBatch);
		
		

}
