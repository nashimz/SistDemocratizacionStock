package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.models.StoreModel;

import java.util.List;


public interface IStoreService {
	public List<Store> getAll();
	
	public StoreModel findById(int id);
	
	StoreModel insertOrUpdate(StoreModel storeModel);
	
	public boolean remove(int id);

}
