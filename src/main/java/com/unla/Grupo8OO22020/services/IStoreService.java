package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.models.ProductModel;
import com.unla.Grupo8OO22020.models.StoreModel;


import java.time.LocalDate;
import java.util.List;


public interface IStoreService {
	
	public List<Store> getAll();
	
	public List<StoreModel> getAlls();
	
	public StoreModel findByIdStore(long idStore);
	
	public StoreModel insert(StoreModel storeModel);
	
	public StoreModel update(StoreModel storeModel);
	
	public boolean remove(long idStore);

	public List<StoreModel> getNearestStore(StoreModel storeModel);

	public List<ProductModel> soldProductsBetweenDates(StoreModel store, LocalDate since, LocalDate until);


	public List<StoreModel> getNearestStoreStock(StoreModel storeModel, ProductModel productModel, int quantity);


}
