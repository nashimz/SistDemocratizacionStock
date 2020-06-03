package com.unla.Grupo8OO22020.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo8OO22020.entities.StockRequest;


@Repository("stockRequestRepository")
public interface IStockRequestRepository extends JpaRepository<StockRequest, Serializable> {
 
	public abstract StockRequest findByIdPedido(long idPedido);


}