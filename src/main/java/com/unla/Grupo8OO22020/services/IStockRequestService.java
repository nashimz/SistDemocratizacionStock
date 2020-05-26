package com.unla.Grupo8OO22020.services;

import java.util.List;

import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.entities.StockRequest;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.PersonModel;
import com.unla.Grupo8OO22020.models.StockRequestModel;

public interface IStockRequestService {
	
	public abstract List<StockRequest> getAll();
	   
    public abstract List<StockRequestModel> getAlls();
	
	public abstract  StockRequestModel insert(StockRequestModel stockRequestModel);
	
	public abstract StockRequestModel update(StockRequestModel stockRequestModel);
	
	public abstract boolean remove(long idStockRequest);
	
	public abstract StockRequestModel findByIdStockRequest(long idStockRequest);


}
