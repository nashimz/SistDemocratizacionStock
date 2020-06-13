package com.unla.Grupo8OO22020.services;

import java.util.List;
import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.ProductModel;
import com.unla.Grupo8OO22020.models.RankingProductModel;
import com.unla.Grupo8OO22020.models.StoreModel;


public interface IPedidoService {
	
	public  List<Pedido> getAll();
	   
    public  List<PedidoModel> getAlls();
	
	public  PedidoModel insert(PedidoModel pedidoModel);
	
	public  PedidoModel update(PedidoModel pedidoModel);
	
	public  boolean remove(long idPedido);

	public PedidoModel findByIdPedido(long idPedido);
	

	public List<RankingProductModel> rankingProduct(List<Pedido> pedidos);

	public void setAttributes(PedidoModel pedidoModel);

	public void paySalary(EmployeeModel employeeModel,EmployeeModel collaborator,ProductModel productModel,int quantity);

	public List<BatchModel> getActiveBatches(StoreModel storeModel, ProductModel productModel);

	public int calculateStock(StoreModel storeModel, ProductModel productModel);

	public boolean validarConsumo(StoreModel storeModel, ProductModel productModel, int quantity);

	public void consumoStock(StoreModel storeModel, ProductModel productModel, int quantity);

	public void setAttributeRequest(PedidoModel pedidoModel, StoreModel storeModel);

	public List<EmployeeModel> paySalary(int month, int year);

}
