package com.unla.Grupo8OO22020.services;


import java.util.List;

import com.unla.Grupo8OO22020.entities.Product;
import com.unla.Grupo8OO22020.models.ProductModel;




public interface IProductService {

	public abstract List<Product> getAll();
	
	public abstract List<ProductModel> getAlls();
	
	public abstract ProductModel findByIdProduct(long idProduct);
	
	public abstract ProductModel findByDescription(String description);
	
	public abstract ProductModel findBySize(String size);
	
	public abstract boolean remove(long idProduct);

	public abstract ProductModel insertOrUpdate(ProductModel productModel);
	
	public List<ProductModel> findByDescriptionName(String descriptionName);
	
	public List<ProductModel> findBySizeName(String sizeName);
	
	
}