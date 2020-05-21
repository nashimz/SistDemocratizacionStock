package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.Grupo8OO22020.entities.Product;


@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Serializable> {

	public abstract Product findByIdProduct(long idProduct);
	
	public abstract Product findByDescription(String description);
	
	public abstract Product findBySize(String size);
	
	// Todas los productos que tengan una descripcion con ese nombre (parámetro descripcion)
	@Query("SELECT p FROM  Product p WHERE p.description = (:description)")
	public abstract List<Product> findByDescriptionName(String description);
	
	// Todas los productos que tengan ese talle (parámetro talle)
	@Query("SELECT p FROM  Product p WHERE p.size = (:size)")
	public abstract List<Product> findBySizeName(String size);
	
	
	
}