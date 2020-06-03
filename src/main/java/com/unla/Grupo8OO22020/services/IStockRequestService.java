package com.unla.Grupo8OO22020.services;

import java.util.List;

import com.unla.Grupo8OO22020.entities.StockRequest;
import com.unla.Grupo8OO22020.models.StockRequestModel;


public interface IStockRequestService {
	
    public List<StockRequest> getAll();
	
	public List<StockRequestModel> getAlls();
	
	public StockRequestModel findByIdPedido(long idPedido);
	
	public StockRequestModel insert(StockRequestModel stockRequestModel);
	
	public StockRequestModel update(StockRequestModel stockRequestModel);
	
	public boolean remove(long idPedido);

	
	

}
