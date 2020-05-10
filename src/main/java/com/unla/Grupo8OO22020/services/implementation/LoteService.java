package com.unla.Grupo8OO22020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.services.ILoteService;
import java.util.List;

import com.unla.Grupo8OO22020.entities.Lote;
import com.unla.Grupo8OO22020.models.LoteModel;
import com.unla.Grupo8OO22020.converters.LoteConverter;
import com.unla.Grupo8OO22020.repositories.ILoteRepository;
import com.unla.Grupo8OO22020.services.IProductoService;





@Service("loteService")
public class LoteService implements  ILoteService{
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Override
	public List<Lote> getAll() {
		return loteRepository.findAll();
	}	
	
	@Override
	public LoteModel insert(LoteModel loteModel) {
		Lote lote=loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
	}
	
	@Override
	public LoteModel update(LoteModel loteModel) {
		loteModel.setProducto(productoService.findByIdProducto(loteModel.getProducto().getIdProducto()));
	    Lote lote=loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
	}
	
	@Override
	public LoteModel findByIdLote(long idLote) {
		return loteConverter.entityToModel(loteRepository.findByIdLote(idLote));
	}
	
	@Override
	public boolean remove(long idLote) {
		try {
			loteRepository.deleteById(idLote);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

}
