package com.unla.Grupo8OO22020.services.implementation;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.services.IStoreService;
import com.unla.Grupo8OO22020.repositories.IStoreRepository;
import com.unla.Grupo8OO22020.converters.StoreConverter;
import com.unla.Grupo8OO22020.models.StoreModel;

@Service("storeService")
public class StoreService  implements IStoreService{
	@Autowired
	@Qualifier("storeRepository")
	private IStoreRepository storeRepository;
	
	@Autowired
	@Qualifier("storeConverter")
	private StoreConverter storeConverter;
	
	@Override
	public List<Store> getAll() {
		return storeRepository.findAll();
	}
	
	@Override
	public StoreModel insertOrUpdate(StoreModel storeModel) {
		Store store = storeRepository.save(storeConverter.modelToEntity(storeModel));
		return storeConverter.entityToModel(store);
	}

	@Override
	public StoreModel findByIdStore(long idStore) {
		return storeConverter.entityToModel(storeRepository.findByIdStore(idStore));
	}
	
	
	@Override
	public List<StoreModel> findByIdBatch(long idBatch) {
		List<StoreModel> models = new ArrayList<StoreModel>();
		for (Store store : storeRepository.findByIdBatch(idBatch)) {
			models.add(storeConverter.entityToModel(store));
		}
		return models;
	}
	

	@Override
	public boolean remove(long idStore) {
		try {
			storeRepository.deleteById(idStore);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}