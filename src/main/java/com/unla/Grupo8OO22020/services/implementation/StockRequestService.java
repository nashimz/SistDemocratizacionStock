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
		stockRequestModel.setStore1(storeService.findByIdStore(stockRequestModel.getStore1().getIdStore()));
		stockRequestModel.setStore2(storeService.findByIdStore(stockRequestModel.getStore2().getIdStore()));
		stockRequestModel.setProduct(productService.findByIdProduct(stockRequestModel.getProduct().getIdProduct()));
		stockRequestModel.setCollaborator(employeeService.findById(stockRequestModel.getCollaborator().getId()));
		stockRequestModel.setEmployee(employeeService.findById(stockRequestModel.getEmployee().getId()));
		StockRequest stockRequest = stockRequestRepository.save(stockRequestConverter.modelToEntity(stockRequestModel));
		return stockRequestConverter.entityToModel(stockRequest);
	}
	
	public StockRequestModel update(StockRequestModel stockRequestModel) {
		stockRequestModel.setStore1(storeService.findByIdStore(stockRequestModel.getStore1().getIdStore()));
		stockRequestModel.setStore2(storeService.findByIdStore(stockRequestModel.getStore2().getIdStore()));
		stockRequestModel.setProduct(productService.findByIdProduct(stockRequestModel.getProduct().getIdProduct()));
		stockRequestModel.setCollaborator(employeeService.findById(stockRequestModel.getCollaborator().getId()));
		stockRequestModel.setEmployee(employeeService.findById(stockRequestModel.getEmployee().getId()));
		StockRequest stockRequest = stockRequestRepository.save(stockRequestConverter.modelToEntity(stockRequestModel));
		return stockRequestConverter.entityToModel(stockRequest);
	}
	
	public  StockRequestModel findByIdStockRequest(long idStockRequest) {
		return stockRequestConverter.entityToModel(stockRequestRepository.findByIdStockRequest(idStockRequest));
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
	public boolean remove(long idStockRequest) {
		try {
			stockRequestRepository.deleteById(idStockRequest);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}