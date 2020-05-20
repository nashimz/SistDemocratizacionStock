package com.unla.Grupo8OO22020.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.entities.Batch;

@Component("batchConverter")
public class BatchConverter {
	
	@Autowired()
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Autowired()
	@Qualifier("storeConverter")
	private StoreConverter storeConverter;
	
	public BatchModel entityToModel(Batch batch) {
		return new BatchModel(batch.getIdBatch(),productConverter.entityToModel(batch.getProduct()),batch.getQuantity(),batch.getQuantities(),storeConverter.entityToModel(batch.getStore()));
	}
	
	public Batch modelToEntity(BatchModel batchModel) {
		return new Batch(batchModel.getIdBatch(),productConverter.modelToEntity(batchModel.getProduct()),batchModel.getQuantity(),batchModel.getQuantities(),storeConverter.modelToEntity(batchModel.getStore()));
	}

}