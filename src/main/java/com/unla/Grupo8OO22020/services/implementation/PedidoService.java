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
import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.ProductModel;
import com.unla.Grupo8OO22020.models.RankingProductModel;
import com.unla.Grupo8OO22020.models.StoreModel;
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
	public void setAttributes(PedidoModel pedidoModel) {
		pedidoModel.setProduct(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()));
		pedidoModel.setEmployee(employeeService.findById(pedidoModel.getEmployee().getId()));
		
		pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()));
		pedidoModel.setSubtotal(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice()*pedidoModel.getQuantity());
		
	}
	
	@Override
	public void setAttributeRequest(PedidoModel pedidoModel,StoreModel storeModel) {
		PedidoModel pedido =this.findByIdPedido(pedidoModel.getIdPedido());
		StoreModel stores = storeService.findByIdStore(storeModel.getIdStore());
		pedidoModel.setCollaborator(employeeService.findByIdStores(stores.getIdStore()));
		pedidoModel.setProduct(productService.findByIdProduct(pedido.getProduct().getIdProduct()));
		pedidoModel.setEmployee(employeeService.findById(pedido.getEmployee().getId()));
		pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedido.getEmployee().getId()).getStore().getIdStore()));
		pedidoModel.setSubtotal(productService.findByIdProduct(pedido.getProduct().getIdProduct()).getPrice() * pedido.getQuantity());
		pedidoModel.setQuantity(pedido.getQuantity());
		pedidoModel.setDate(pedido.getDate());
		pedidoModel.setAccept(pedido.isAccept());
	}
	
	@Override
	public PedidoModel insert(PedidoModel pedidoModel) {
		Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel update(PedidoModel pedidoModel) {
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
	
	
	//trae la lista de todos los lotes activos del local que contienen ese producto
	@Override
	public List<BatchModel> getActiveBatches(StoreModel storeModel,ProductModel productModel) {
		List<BatchModel> activeBatches = new ArrayList<BatchModel>();
			for (BatchModel b : batchService.getAlls()) {
				if (b.getProduct().getIdProduct() ==productModel.getIdProduct() && b.getStore().getIdStore() ==storeModel.getIdStore() && b.isActive()) {
					activeBatches.add(b);
				}
			}
			return activeBatches;
		}

	@Override
	public int calculateStock(StoreModel storeModel,ProductModel productModel) {
		int total = 0;
			for (BatchModel batchModel : getActiveBatches(storeModel,productModel) ){
				total += batchModel.getQuantities();
			}
			return total;
			
		}
		
    @Override
	public boolean validarConsumo(StoreModel storeModel,ProductModel productModel,int quantity) {
		return (calculateStock(storeModel,productModel) >= quantity) ? true : false; 
		}
		
	@Override
	public void consumoStock(StoreModel storeModel,ProductModel productModel, int quantity) {
			
		 for(BatchModel b: this.getActiveBatches(storeModel, productModel)) {
				if (b.getQuantities() > quantity) {
					b.setQuantities(b.getQuantities()-quantity);
					quantity = 0;
				} else if (b.getQuantities() < quantity) { 
					quantity -= b.getQuantities();
					b.setQuantities(0);	
					b.setActive(false);
				} else if (b.getQuantities() == quantity) {
					quantity = 0;
					b.setQuantities(0);
					b.setActive(false);
				}
				BatchModel bM = batchService.findByIdBatch(b.getIdBatch());
				bM.setQuantities(b.getQuantities());
				bM.setActive(b.isActive());
				batchService.insert(bM);
			}
			
		}
	
	@Override
	public void paySalary(EmployeeModel employeeModel,EmployeeModel collaborator,ProductModel productModel, int quantity) {
		double subtotal=productService.findByIdProduct(productModel.getIdProduct()).getPrice()*quantity;
		if(employeeModel.getDni()==collaborator.getDni()) {
		employeeModel.setCommission(employeeModel.getCommission()+subtotal*0.05);
		}
		else{
			employeeModel.setCommission(employeeModel.getCommission()+subtotal*0.03);
			collaborator.setCommission(collaborator.getCommission()+subtotal*0.02);
			employeeService.insertOrUpdate(collaborator);
		}
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
	public List<EmployeeModel> paySalary(int month,int year){
		List<EmployeeModel> salaryEmployees=new ArrayList<EmployeeModel>();
		List<EmployeeModel> listSalary=employeeService.getAllv();
		double commission=0;
		for(EmployeeModel e:listSalary) {
			e.setCommission(0);
			e.setFullSalary(e.getBasicSalary());
		}
		
		for(EmployeeModel e:listSalary) {
		   for(PedidoModel p:this.getAlls()) {
			  if(p.isAccept() && p.getDate().getMonthValue()==month && p.getDate().getYear()==year) {
				if(p.getCollaborator().getDni()==p.getEmployee().getDni()) {
					commission=p.getSubtotal()*0.05;
					
			     }else if(p.getCollaborator().getDni()!=p.getEmployee().getDni() &&e.getDni()==p.getEmployee().getDni()) {
					      commission=p.getSubtotal()*0.03;
					     
			            }else if(p.getCollaborator().getDni()!=p.getEmployee().getDni() &&e.getDni()==p.getCollaborator().getDni())
				                  commission=p.getSubtotal()*0.02;
		      }
	          e.setCommission(commission);
	          System.out.println(e.getCommission());
	        }
		   e.setFullSalary(e.getFullSalary()+e.getCommission());
		   salaryEmployees.add(e);
		}
		return salaryEmployees;   
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
