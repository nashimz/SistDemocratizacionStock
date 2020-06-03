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
		return new StockRequestModel(stockRequest.getIdPedido(),stockRequest.getQuantity(),productConverter.entityToModel(stockRequest.getProduct()),storeConverter.entityToModel(stockRequest.getStore()),employeeConverter.entityToModel(stockRequest.getEmployee()),stockRequest.getDate(),stockRequest.getSubtotal(),storeConverter.entityToModel(stockRequest.getStoreCollaborator()),employeeConverter.entityToModel(stockRequest.getCollaborator()),stockRequest.isAccept());
	}
	
	public StockRequest modelToEntity(StockRequestModel stockRequestModel) {
		return new StockRequest(stockRequestModel.getIdPedido(),stockRequestModel.getQuantity(),productConverter.modelToEntity(stockRequestModel.getProduct()),storeConverter.modelToEntity(stockRequestModel.getStore()),employeeConverter.modelToEntity(stockRequestModel.getEmployee()),stockRequestModel.getDate(),stockRequestModel.getSubtotal(),storeConverter.modelToEntity(stockRequestModel.getStoreCollaborator()), employeeConverter.modelToEntity(stockRequestModel.getCollaborator()),stockRequestModel.isAccept());
	}

}