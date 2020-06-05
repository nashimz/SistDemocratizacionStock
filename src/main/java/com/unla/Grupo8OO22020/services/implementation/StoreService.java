package com.unla.Grupo8OO22020.services.implementation;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.services.IPedidoService;
import com.unla.Grupo8OO22020.services.IStoreService;
import com.unla.Grupo8OO22020.repositories.IStoreRepository;
import com.unla.Grupo8OO22020.converters.StoreConverter;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.ProductModel;
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
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Override
	public StoreModel insert(StoreModel storeModel) {
		Store store = storeRepository.save(storeConverter.modelToEntity(storeModel));
		return storeConverter.entityToModel(store);
	}
	
	
	@Override
	public StoreModel update(StoreModel storeModel) {
	    Store store=storeRepository.save(storeConverter.modelToEntity(storeModel));
		return storeConverter.entityToModel(store);
	}

	@Override
	public StoreModel findByIdStore(long idStore) {
		return storeConverter.entityToModel(storeRepository.findByIdStore(idStore));
	}
	
	@Override
	public List<StoreModel> getNearestStore(StoreModel storeModel) {
		List<StoreModel> stores = new ArrayList<StoreModel>();
		for (Store store : storeRepository.findAll()) {
			StoreModel model=storeConverter.entityToModel(store);
			if (model.getIdStore()!=storeModel.getIdStore()){
				double distance =Store.distanciaCoord(storeModel.getLatitude(), storeModel.getLongitude(), model.getLatitude(), model.getLongitude());
				model.setDistance(Math.round(distance*100)/100.00);
				stores.add(model);
			}
		}
		stores.sort(Comparator.comparing(StoreModel::getDistance));
		return stores;
	}
	
	@Override
	public List<StoreModel> getAlls() {
		List<StoreModel> models = new ArrayList<StoreModel>();
		for (Store store : storeRepository.findAll()) {
			models.add(storeConverter.entityToModel(store));
		}
		return models;
	}
	
	@Override
	public List<ProductModel> soldProductsBetweenDates(StoreModel store, LocalDate since,LocalDate until) {
         int index=0;
         List<ProductModel> products=new ArrayList<ProductModel>();
         List<PedidoModel> pedidos=pedidoService.getAlls();
		 while(index<pedidos.size()) {
			if (pedidos.get(index).getDate().isBefore(until) && pedidos.get(index).getDate().isAfter(since)) {
				if (pedidos.get(index).isAccept() && pedidos.get(index).getStore().getIdStore()==store.getIdStore()) {
					products.add(pedidos.get(index).getProduct());
				}
			}
			index++;
		}
	  return products;
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