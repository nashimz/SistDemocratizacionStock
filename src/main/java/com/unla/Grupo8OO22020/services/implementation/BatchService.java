package com.unla.Grupo8OO22020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.services.IBatchService;
import java.util.ArrayList;
import java.util.List;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.converters.BatchConverter;
import com.unla.Grupo8OO22020.repositories.IBatchRepository;
import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.services.IStoreService;

@Service("batchService")
public class BatchService implements  IBatchService{
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;

	@Autowired
	@Qualifier("batchRepository")
	private IBatchRepository batchRepository;
	
	@Autowired
	@Qualifier("batchConverter")
	private BatchConverter batchConverter;
	
	@Override
	public List<Batch> getAll() {
		return batchRepository.findAll();
	}	
	
	@Override
	public BatchModel insert(BatchModel batchModel) {
		batchModel.setStore(storeService.findByIdStore(batchModel.getStore().getIdStore()));
		Batch batch=batchRepository.save(batchConverter.modelToEntity(batchModel));
		return batchConverter.entityToModel(batch);
	}
	
	@Override
	public BatchModel update(BatchModel batchModel) {
		batchModel.setProduct(productService.findByIdProduct(batchModel.getProduct().getIdProduct()));
		batchModel.setStore(storeService.findByIdStore(batchModel.getStore().getIdStore()));
	    Batch batch=batchRepository.save(batchConverter.modelToEntity(batchModel));
		return batchConverter.entityToModel(batch);
	}
	
	
	@Override
	public BatchModel findByIdBatch(long idBatch) {
		return batchConverter.entityToModel(batchRepository.findByIdBatch(idBatch));
	}
	
	@Override
	public List<BatchModel> getAlls() {
		List<BatchModel> models = new ArrayList<BatchModel>();
		for (Batch batch : batchRepository.findAll()) {
			models.add(batchConverter.entityToModel(batch));
		}
		return models;
	}
	
	@Override
	public List<BatchModel> findByIdStore(long idStore) {
		List<BatchModel> models = new ArrayList<BatchModel>();
		for (Batch batch : batchRepository.findByIdStore(idStore)) {
			models.add(batchConverter.entityToModel(batch));
		}
		return models;
	}
	
	@Override
	public List<BatchModel> findByIdProduct(long idProduct) {
		List<BatchModel> models = new ArrayList<BatchModel>();
		for (Batch batch : batchRepository.findByIdProduct(idProduct)) {
			models.add(batchConverter.entityToModel(batch));
		}
		return models;
	}
	
	@Override
	public boolean remove(long idBatch) {
		try {
			batchRepository.deleteById(idBatch);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

}
