package com.unla.Grupo8OO22020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.services.IBatchService;
import java.util.List;

import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.converters.BatchConverter;
import com.unla.Grupo8OO22020.repositories.IBatchRepository;
import com.unla.Grupo8OO22020.services.IProductService;





@Service("batchService")
public class BatchService implements  IBatchService{
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;

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
		Batch batch=batchRepository.save(batchConverter.modelToEntity(batchModel));
		return batchConverter.entityToModel(batch);
	}
	
	@Override
	public BatchModel update(BatchModel batchModel) {
		batchModel.setProduct(productService.findByIdProduct(batchModel.getProduct().getIdProduct()));
	    Batch batch=batchRepository.save(batchConverter.modelToEntity(batchModel));
		return batchConverter.entityToModel(batch);
	}
	
	@Override
	public BatchModel findByIdBatch(long idBatch) {
		return batchConverter.entityToModel(batchRepository.findByIdBatch(idBatch));
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
