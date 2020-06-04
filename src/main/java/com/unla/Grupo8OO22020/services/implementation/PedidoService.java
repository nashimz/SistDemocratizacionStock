package com.unla.Grupo8OO22020.services.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo8OO22020.converters.PedidoConverter;
import com.unla.Grupo8OO22020.entities.Batch;
import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.entities.Product;
import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.RankingProductModel;
import com.unla.Grupo8OO22020.repositories.IPedidoRepository;
import com.unla.Grupo8OO22020.services.IBatchService;
import com.unla.Grupo8OO22020.services.IEmployeeService;
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
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
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
		//pedidoModel.setEmployee(employeeService.findById(pedidoModel.getEmployee().getId()));
		//pedidoModel.setStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore());
		//pedidoModel.setSubtotal(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice()*pedidoModel.getQuantity());
		Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel update(PedidoModel pedidoModel) {
		//pedidoModel.setEmployee(employeeService.findById(pedidoModel.getEmployee().getId()));
		//pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()));
		//pedidoModel.setSubtotal(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice()*pedidoModel.getQuantity());
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
	public List<Batch> getActiveBatches(PedidoModel pedidoModel) {
		List<Batch> activeBatches = new ArrayList<Batch>();
		System.out.println(pedidoModel.getStore().getAddress());
			for (Batch b : batchService.getAll()) {
				if (b.getProduct().getIdProduct() == pedidoModel.getProduct().getIdProduct() && b.getStore().getIdStore() ==pedidoModel.getStore().getIdStore() && b.isActive()) {
					activeBatches.add(b);
				}
			}
			return activeBatches;
		}

	@Override
	public int calculateStock(PedidoModel pedidoModel) {
		int total = 0;
			for (Batch b : getActiveBatches(pedidoModel)) {
				total += b.getQuantities();
			}
			return total;
		}
		
    @Override
	public boolean validarConsumo(PedidoModel pedidoModel) {
		return (calculateStock(pedidoModel) >= pedidoModel.getQuantity()) ? true : false; 
		}
		
	@Override
	public void consumoStock(PedidoModel pedidoModel) {
	     int aux = pedidoModel.getQuantity();
	     double aux2= productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice();
		 int x = 0;
			while (x < getActiveBatches(pedidoModel).size() && aux > 0) {
				Batch b = getActiveBatches(pedidoModel).get(x);
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
			double plus = ((aux2 * 5) / 100) * pedidoModel.getQuantity();
			EmployeeModel employeeModel = employeeService.findById(pedidoModel.getEmployee().getId());
			employeeModel.setCommission(pedidoModel.getEmployee().getCommission() + plus);
			employeeService.insertOrUpdate(employeeModel);	
		}
	
	@Override
	public List<RankingProductModel> rankingProduct(List<Pedido> pedidos){
		Map<String,Integer> ranking = new HashMap<String,Integer>();
		List<RankingProductModel> rankingProd = new ArrayList<RankingProductModel>();
		for(Pedido p: pedidos) {
			if(p.isAccept()) {
				if(!ranking.containsKey(p.getProduct().getDescription())) {
					ranking.put(p.getProduct().getDescription(), p.getQuantity());
				}
				else {
					ranking.replace(p.getProduct().getDescription(), ranking.get(p.getProduct().getDescription())+p.getQuantity());
				}
			}
		}

		for(String key : ranking.keySet()) {
			rankingProd.add(new RankingProductModel(key, ranking.get(key)));
		}
		
		Collections.sort(rankingProd, Collections.reverseOrder(Comparator.comparing(RankingProductModel::getQuantitySold)));
		return rankingProd;
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
