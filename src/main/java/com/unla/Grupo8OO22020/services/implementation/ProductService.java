package com.unla.Grupo8OO22020.services.implementation;



import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo8OO22020.converters.ProductConverter;
import com.unla.Grupo8OO22020.entities.Product;
import com.unla.Grupo8OO22020.models.ProductModel;
import com.unla.Grupo8OO22020.repositories.IProductRepository;
import com.unla.Grupo8OO22020.services.IProductService;


@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	@Qualifier("productRepository")
	private IProductRepository productRepository;
	
	@Autowired
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	@Override
	public ProductModel insertOrUpdate(ProductModel productModel) {
		Product product = productRepository.save(productConverter.modelToEntity(productModel));
		return productConverter.entityToModel(product);
	}
	
	@Override
	public ProductModel findByIdProduct(long idProduct) {
		return productConverter.entityToModel(productRepository.findByIdProduct(idProduct));
	}

	@Override
	public ProductModel findByDescription(String description) {
		return productConverter.entityToModel(productRepository.findByDescription(description));
	}
	
	@Override
	public ProductModel findBySize(String size) {
		return productConverter.entityToModel(productRepository.findBySize(size));
	}
	
	@Override
	public List<ProductModel> findByDescriptionName(String descriptionName) {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (Product product : productRepository.findByDescriptionName(descriptionName)) {
			models.add(productConverter.entityToModel(product));
		}
		return models;
	}
	
	@Override
	public List<ProductModel> findBySizeName(String sizeName) {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (Product product : productRepository.findBySizeName(sizeName)) {
			models.add(productConverter.entityToModel(product));
		}
		return models;
	}
	
	
	@Override
	public boolean remove(long idProduct) {
		try {
			productRepository.deleteById(idProduct);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}