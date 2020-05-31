package com.unla.Grupo8OO22020.services;

import java.util.List;


import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.models.PedidoModel;


public interface IPedidoService {
	
	public  List<Pedido> getAll();
	   
    public  List<PedidoModel> getAlls();
	
	public  PedidoModel insert(PedidoModel pedidoModel);
	
	public  PedidoModel update(PedidoModel pedidoModel);
	
	public  boolean remove(long idPedido);

	public PedidoModel findByIdPedido(long idPedido);
	
	public List<Batch> getActiveBatches(PedidoModel pedidoModel);
	
	public int calculateStock(PedidoModel pedidoModel);
	
	public boolean validarConsumo(PedidoModel pedidoModel);
	
	public void consumoStock(PedidoModel pedidoModel );

}
