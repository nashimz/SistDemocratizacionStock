package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.entities.Product;
import com.unla.Grupo8OO22020.entities.Store;

@Repository("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {
	
	public abstract Pedido findByIdPedido(long idPedido);
	
	//ver si se necesita
	public abstract Pedido findByProduct(Product product);
	
	//ver si se necesita
	public abstract Pedido findByStore(Store store);
	
	//ver si la necesito
	@Query("SELECT p FROM Pedido p JOIN FETCH p.store s WHERE s.idStore = (:idStore)")
	public abstract List<Pedido> findByIdStore(long idStore);

}
