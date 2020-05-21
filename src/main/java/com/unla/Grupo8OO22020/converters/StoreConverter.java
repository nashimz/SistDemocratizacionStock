package com.unla.Grupo8OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.models.StoreModel;

@Component("storeConverter")
public class StoreConverter {
	
	@Autowired()
	@Qualifier("employeeConverter")
	private EmployeeConverter employeeConverter;
	
	public StoreModel entityToModel(Store store) {
		return new StoreModel(store.getIdStore(), store.getPhone(), store.getAddress(), store.getLatitude(), store.getLongitude(),employeeConverter.entityToModel(store.getManager()));
	}

	public Store modelToEntity(StoreModel storeModel) {
		return new Store(storeModel.getIdStore(), storeModel.getPhone(), storeModel.getAddress(), storeModel.getLatitude(),storeModel.getLongitude(),employeeConverter.modelToEntity(storeModel.getManager()));
	}
}
