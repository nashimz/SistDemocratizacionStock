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
import com.unla.Grupo8OO22020.services.IStockRequestService;


@Service("stockRequestService")
public class StockRequestService implements IStockRequestService  {

	@Autowired
	@Qualifier("stockRequestRepository")
	private IStockRequestRepository stockRequestRepository;
	
	@Autowired
	@Qualifier("stockRequestConverter")
	private StockRequestConverter stockRequestConverter;
	
	@Override
	public List<StockRequest> getAll() {
		return stockRequestRepository.findAll();
	}
	
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
	
	public StockRequestModel insert(StockRequestModel stockRequestModel) {
		StockRequest sr = stockRequestRepository.save(stockRequestConverter.modelToEntity(stockRequestModel));
		return stockRequestConverter.entityToModel(sr);
	}
	
	public StockRequestModel update(StockRequestModel stockRequestModel) {
		StockRequest sr = stockRequestRepository.save(stockRequestConverter.modelToEntity(stockRequestModel));
		return stockRequestConverter.entityToModel(sr);
	}
	
	public  StockRequestModel findByIdStockRequest(long idStockRequest) {
		return stockRequestConverter.entityToModel(stockRequestRepository.findByIdStockRequest(idStockRequest));
	}
	
}