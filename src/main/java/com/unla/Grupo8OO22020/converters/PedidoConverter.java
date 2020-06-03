package com.unla.Grupo8OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.unla.Grupo8OO22020.entities.Pedido;

import com.unla.Grupo8OO22020.models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {
	
	@Autowired()
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Autowired()
	@Qualifier("storeConverter")
	private StoreConverter storeConverter;
	
	@Autowired()
	@Qualifier("employeeConverter")
	private EmployeeConverter employeeConverter;

	
	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(pedido.getIdPedido(),pedido.getQuantity(),productConverter.entityToModel(pedido.getProduct()),storeConverter.entityToModel(pedido.getStore()),employeeConverter.entityToModel(pedido.getEmployee()),pedido.getDate(),pedido.getSubtotal());
	}
	
	public Pedido modelToEntity(PedidoModel pedidoModel) {
		return new Pedido(pedidoModel.getIdPedido(),pedidoModel.getQuantity(),productConverter.modelToEntity(pedidoModel.getProduct()),storeConverter.modelToEntity(pedidoModel.getStore()),employeeConverter.modelToEntity(pedidoModel.getEmployee()),pedidoModel.getDate(),pedidoModel.getSubtotal());
	}

}
