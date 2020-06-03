package com.unla.Grupo8OO22020.services.implementation;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.converters.StockRequestConverter;
import com.unla.Grupo8OO22020.entities.StockRequest;
import com.unla.Grupo8OO22020.models.StockRequestModel;
import com.unla.Grupo8OO22020.repositories.IStockRequestRepository;
import com.unla.Grupo8OO22020.services.IEmployeeService;
import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.services.IStockRequestService;
import com.unla.Grupo8OO22020.services.IStoreService;


@Service("stockRequestService")
public class StockRequestService implements IStockRequestService  {

	@Autowired
	@Qualifier("stockRequestRepository")
	private IStockRequestRepository stockRequestRepository;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("stockRequestConverter")
	private StockRequestConverter stockRequestConverter;
	
	@Override
	public List<StockRequest> getAll() {
		return stockRequestRepository.findAll();
	}
	
	public StockRequestModel insert(StockRequestModel stockRequestModel) {
		stockRequestModel.setEmployee(employeeService.findById(stockRequestModel.getEmployee().getId()));
		stockRequestModel.setCollaborator(employeeService.findById(stockRequestModel.getCollaborator().getId()));
		stockRequestModel.setStore(storeService.findByIdStore(stockRequestModel.getStore().getIdStore()));
		stockRequestModel.setStoreCollaborator(storeService.findByIdStore(stockRequestModel.getStoreCollaborator().getIdStore()));
		StockRequest stockRequest = stockRequestRepository.save(stockRequestConverter.modelToEntity(stockRequestModel));
		return stockRequestConverter.entityToModel(stockRequest);
	}
	
	public StockRequestModel update(StockRequestModel stockRequestModel) {
		stockRequestModel.setEmployee(employeeService.findById(stockRequestModel.getEmployee().getId()));
		stockRequestModel.setCollaborator(employeeService.findById(stockRequestModel.getCollaborator().getId()));
		stockRequestModel.setStore(storeService.findByIdStore(stockRequestModel.getStore().getIdStore()));
		stockRequestModel.setStoreCollaborator(storeService.findByIdStore(stockRequestModel.getStoreCollaborator().getIdStore()));;
		StockRequest stockRequest = stockRequestRepository.save(stockRequestConverter.modelToEntity(stockRequestModel));
		return stockRequestConverter.entityToModel(stockRequest);
	}
	
	public  StockRequestModel findByIdPedido(long idPedido) {
		return stockRequestConverter.entityToModel(stockRequestRepository.findByIdPedido(idPedido));
	}
	
	@Override
	public List<StockRequestModel> getAlls() {
		List<StockRequestModel> models = new ArrayList<StockRequestModel>();
		for (StockRequest sr : stockRequestRepository.findAll()) {
			models.add(stockRequestConverter.entityToModel(sr));
		}
		return models;
	}
	
	@Override
	public boolean remove(long idPedido) {
		try {
			stockRequestRepository.deleteById(idPedido);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}