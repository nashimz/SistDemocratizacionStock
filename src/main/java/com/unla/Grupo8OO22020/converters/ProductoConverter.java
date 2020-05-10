package com.unla.Grupo8OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo8OO22020.entities.Producto;
import com.unla.Grupo8OO22020.models.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {

	public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(producto.getIdProducto(), producto.getDescripcion(),producto.getPrecio());
	}

	public Producto modelToEntity(ProductoModel productoModel) {
		return new Producto(productoModel.getIdProducto(), productoModel.getDescripcion(),productoModel.getPrecio());
	}
}