package com.unla.Grupo8OO22020.services;

import java.util.ArrayList;

import java.util.List;

import com.unla.Grupo8OO22020.entities.Producto;
import com.unla.Grupo8OO22020.models.ProductoModel;




public interface IProductoService {

	public abstract List<Producto> getAll();
	
	public abstract ProductoModel findByIdProducto(long idProducto);
	
	public abstract ProductoModel findByDescripcion(String descripcion);
	
	public abstract ProductoModel findByTalle(String talle);
	
	public abstract boolean remove(long idProducto);

	public abstract ProductoModel insertOrUpdate(ProductoModel productoModel);
	
	public List<ProductoModel> findByDescripcionName(String descripcionName);
	
	public List<ProductoModel> findByTalleName(String talleName);
	
	
}