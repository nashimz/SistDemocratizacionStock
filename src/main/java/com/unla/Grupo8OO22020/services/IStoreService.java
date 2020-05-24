package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Store;

import com.unla.Grupo8OO22020.models.StoreModel;

import java.util.List;


public interface IStoreService {
	public List<Store> getAll();
	
	public List<StoreModel> getAlls();
	
	public StoreModel findByIdStore(long idStore);
	
	StoreModel insert(StoreModel storeModel);
	
	StoreModel update(StoreModel storeModel);
	
	public boolean remove(long idStore);
	
	//public List<StoreModel> findByIdBatch(long idBatch);
	
	

}
