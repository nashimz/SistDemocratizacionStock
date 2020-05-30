package com.unla.Grupo8OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.Grupo8OO22020.entities.StockRequest;
import com.unla.Grupo8OO22020.models.StockRequestModel;

@Component("stockRequestConverter")
public class StockRequestConverter {
	
	@Autowired()
	@Qualifier("stockRequestConverter")
	private StockRequestConverter stockRequestConverter;
	
	@Autowired()
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Autowired()
	@Qualifier("storeConverter")
	private StoreConverter storeConverter;
	
	@Autowired()
	@Qualifier("employeeConverter")
	private EmployeeConverter employeeConverter;
	

	public StockRequestModel entityToModel(StockRequest stockRequest) {
		return new StockRequestModel(stockRequest.getIdStockRequest(),stockRequest.getQuantity(),productConverter.entityToModel(stockRequest.getProduct()),storeConverter.entityToModel(stockRequest.getStore1()),storeConverter.entityToModel(stockRequest.getStore2()),employeeConverter.entityToModel(stockRequest.getEmployee()),employeeConverter.entityToModel(stockRequest.getCollaborator()));
	}
	
	public StockRequest modelToEntity(StockRequestModel stockRequestModel) {
		return new StockRequest(stockRequestModel.getIdStockRequest(),stockRequestModel.getQuantity(),productConverter.modelToEntity(stockRequestModel.getProduct()),storeConverter.modelToEntity(stockRequestModel.getStore1()),storeConverter.modelToEntity(stockRequestModel.getStore2()), employeeConverter.modelToEntity(stockRequestModel.getEmployee()), employeeConverter.modelToEntity(stockRequestModel.getCollaborator()));
	}

}