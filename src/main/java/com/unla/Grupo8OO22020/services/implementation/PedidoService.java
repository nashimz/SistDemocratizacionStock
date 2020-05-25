package com.unla.Grupo8OO22020.services.implementation;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.unla.Grupo8OO22020.converters.PedidoConverter;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.ProductModel;
import com.unla.Grupo8OO22020.repositories.IPedidoRepository;
import com.unla.Grupo8OO22020.services.IBatchService;
import com.unla.Grupo8OO22020.services.IPedidoService;
import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.services.IStoreService;


@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}	
	
	@Override
	public PedidoModel insert(PedidoModel pedidoModel) {
		pedidoModel.setStore(storeService.findByIdStore(pedidoModel.getStore().getIdStore()));
		Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel update(PedidoModel pedidoModel) {
		pedidoModel.setProduct(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()));
		pedidoModel.setStore(storeService.findByIdStore(pedidoModel.getStore().getIdStore()));
	    Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel findByIdPedido(long idPedido) {
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(idPedido));
	}
	
	@Override
	public List<PedidoModel> getAlls() {
		List<PedidoModel> models = new ArrayList<PedidoModel>();
		for (Pedido pedido : pedidoRepository.findAll()) {
			models.add(pedidoConverter.entityToModel(pedido));
		}
		return models;
	}
	
	@Override
	public List<Batch> traerLotesProducto(ProductModel productoModel, long idLocal) {
		List<Batch> lotesActivos = new ArrayList<Batch>();
			for (Batch b : batchService.getAll()) {
				if (b.getProduct().getIdProduct() == productoModel.getIdProduct() && b.getStore().getIdStore() == idLocal ) {
					lotesActivos.add(b);
				}
			}
			return lotesActivos;
		}

	@Override
	public int calcularStock(ProductModel productoModel,long idLocal) {
		int total = 0;
			for (Batch b : traerLotesProducto(productoModel, idLocal)) {
				total += b.getQuantities();
			}
			return total;
		}
		
    @Override
	public boolean validarConsumo(ProductModel productoModel,int cantidad, long idLocal) {
		return (calcularStock(productoModel, idLocal) >= cantidad) ? true : false; 
		}
		
	@Override
	public void consumoStock(ProductModel productModel, int cantidad, long idLocal ) {
	  int aux = cantidad;
			int x = 0;

			while (x < traerLotesProducto(productModel, idLocal).size() && aux > 0) {
				Batch b = traerLotesProducto(productModel, idLocal).get(x);

				if (b.getQuantities() > aux) {
					b.setQuantities(b.getQuantities() - aux);
					aux = 0;
				} else if (b.getQuantities() < aux) {
					aux -= b.getQuantities();
					b.setQuantities(0);
					
				} else if (b.getQuantities() == aux) {
					aux = 0;
					b.setQuantities(0);
					
				}
				BatchModel bM = batchService.findByIdBatch(b.getIdBatch());
				bM.setQuantities(b.getQuantities());
				
				batchService.insert(bM);
				x++;

			}

		}
	
	
	@Override
	public boolean remove(long idPedido) {
		try {
			pedidoRepository.deleteById(idPedido);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

}
