package com.unla.Grupo8OO22020.services;

import java.util.List;
import com.unla.Grupo8OO22020.entities.Product;
import com.unla.Grupo8OO22020.models.ProductModel;

public interface IProductService {

	public  List<Product> getAll();
	
	public  List<ProductModel> getAlls();
	
	public  ProductModel findByIdProduct(long idProduct);
	
	public boolean remove(long idProduct);

	public ProductModel insertOrUpdate(ProductModel productModel);
	
	public List<ProductModel> findByDescriptionName(String descriptionName);
	
	public List<ProductModel> findBySizeName(String sizeName);
	
	
}