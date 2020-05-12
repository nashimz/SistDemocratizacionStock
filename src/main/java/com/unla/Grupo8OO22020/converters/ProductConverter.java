package com.unla.Grupo8OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo8OO22020.entities.Product;
import com.unla.Grupo8OO22020.models.ProductModel;

@Component("productConverter")
public class ProductConverter {

	public ProductModel entityToModel(Product product) {
		return new ProductModel(product.getIdProduct(), product.getDescription(),product.getPrice(),product.getSize());
	}

	public Product modelToEntity(ProductModel productModel) {
		return new Product(productModel.getIdProduct(), productModel.getDescription(),productModel.getPrice(),productModel.getSize());
	}
}