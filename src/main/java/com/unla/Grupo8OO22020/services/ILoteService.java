package com.unla.Grupo8OO22020.services;

import java.util.List;
import com.unla.Grupo8OO22020.entities.Lote;
import com.unla.Grupo8OO22020.models.LoteModel;


public interface ILoteService {
	
	public abstract List<Lote> getAll();
	
	public abstract  LoteModel insert(LoteModel loteModel);
	
	public abstract LoteModel update(LoteModel loteModel);
	
	public abstract boolean remove(long idLote);

	public abstract LoteModel findByIdLote(long idLote);

}
