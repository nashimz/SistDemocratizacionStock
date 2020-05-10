package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.Grupo8OO22020.entities.Producto;


@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

	public abstract Producto findByIdProducto(long idProducto);
	
	public abstract Producto findByDescripcion(String descripcion);
	
	public abstract Producto findByTalle(String talle);
	
	// Todas los productos que tengan una descripcion con ese nombre (parámetro descripcion)
	@Query("SELECT p FROM  Producto p WHERE p.descripcion = (:descripcion)")
	public abstract List<Producto> findByDescripcionName(String descripcion);
	
	// Todas los productos que tengan una descripcion con ese nombre (parámetro descripcion)
	@Query("SELECT p FROM  Producto p WHERE p.talle = (:talle)")
	public abstract List<Producto> findByTalleName(String talle);
	
	
	
}