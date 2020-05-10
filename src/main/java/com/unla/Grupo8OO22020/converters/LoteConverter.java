package com.unla.Grupo8OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.Grupo8OO22020.models.LoteModel;
import com.unla.Grupo8OO22020.entities.Lote;

@Component("loteconverter")
public class LoteConverter {
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	public LoteModel entityToModel(Lote lote) {
		return new LoteModel(lote.getIdLote(),productoConverter.entityToModel(lote.getProducto()),lote.getCantidad(),lote.getCantidadTotal(),lote.getFechaIngreso());
	}
	
	public Lote modelToEntity(LoteModel loteModel) {
		return new Lote(loteModel.getIdLote(),productoConverter.modelToEntity(loteModel.getProducto()),loteModel.getCantidad(),loteModel.getCantidadTotal(),loteModel.getFechaIngreso());
	}

}
